package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static volatile d cYK;
    private boolean cYD = false;
    private final HashMap<String, ArrayList<f>> cYJ = new HashMap<>();

    private d() {
    }

    public static d aqq() {
        if (cYK == null) {
            synchronized (d.class) {
                if (cYK == null) {
                    cYK = new d();
                }
            }
        }
        return cYK;
    }

    public String aqk() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void h(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String aqk = aqk();
            ArrayList<f> arrayList = this.cYJ.get(aqk);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f lD = lD(str);
            boolean z = false;
            if (lD != null) {
                if (lD.cYN != i) {
                    lD.cYN = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cYN = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(aqk, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject aqu;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (aqu = fVar.aqu()) != null) {
                    jSONArray.put(aqu);
                    arrayList2.add(fVar);
                }
            }
            if (!v.w(arrayList2)) {
                this.cYJ.put(str, arrayList2);
                if (!this.cYD) {
                    aqr();
                } else {
                    lE(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f lD(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cYJ.get(aqk());
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

    private void lE(String str) {
        l<String> aqm = aqm();
        if (aqm != null) {
            aqm.f("frs_sortType", str);
        }
    }

    public void aqr() {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aqt */
            public l<String> doInBackground() {
                return d.this.aqm();
            }
        }, new h<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: e */
            public void onReturnDataInUI(l<String> lVar) {
                if (lVar != null) {
                    lVar.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aY */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.cYJ.put(d.this.aqk(), d.this.lC(str2));
                            }
                            d.this.cYD = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aqm() {
        return com.baidu.tbadk.core.c.a.td().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> lC(String str) {
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

    public void aqs() {
        lE("");
        this.cYJ.remove(aqk());
    }
}
