package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static volatile d cFC;
    private boolean cFv = false;
    private final HashMap<String, ArrayList<f>> cFB = new HashMap<>();

    private d() {
    }

    public static d alo() {
        if (cFC == null) {
            synchronized (d.class) {
                if (cFC == null) {
                    cFC = new d();
                }
            }
        }
        return cFC;
    }

    public String ali() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void g(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String ali = ali();
            ArrayList<f> arrayList = this.cFB.get(ali);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f kS = kS(str);
            boolean z = false;
            if (kS != null) {
                if (kS.cFF != i) {
                    kS.cFF = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cFF = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(ali, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject als;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (als = fVar.als()) != null) {
                    jSONArray.put(als);
                    arrayList2.add(fVar);
                }
            }
            if (!v.u(arrayList2)) {
                this.cFB.put(str, arrayList2);
                if (!this.cFv) {
                    alp();
                } else {
                    kT(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f kS(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cFB.get(ali());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        fVar = null;
                        break;
                    }
                    fVar = arrayList.get(i2);
                    if (str.equalsIgnoreCase(fVar.forumName)) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                fVar = null;
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    private void kT(String str) {
        l<String> alk = alk();
        if (alk != null) {
            alk.f("frs_sortType", str);
        }
    }

    public void alp() {
        t.a(new s<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: alr */
            public l<String> doInBackground() {
                return d.this.alk();
            }
        }, new g<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: e */
            public void onReturnDataInUI(l<String> lVar) {
                if (lVar != null) {
                    lVar.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aY */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.cFB.put(d.this.ali(), d.this.kR(str2));
                            }
                            d.this.cFv = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> alk() {
        return com.baidu.tbadk.core.c.a.sX().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> kR(String str) {
        ArrayList<f> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new f(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void alq() {
        kT("");
        this.cFB.remove(ali());
    }
}
