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
    private static volatile d cPj;
    private boolean cPc = false;
    private final HashMap<String, ArrayList<f>> cPi = new HashMap<>();

    private d() {
    }

    public static d aoo() {
        if (cPj == null) {
            synchronized (d.class) {
                if (cPj == null) {
                    cPj = new d();
                }
            }
        }
        return cPj;
    }

    public String aoi() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void h(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String aoi = aoi();
            ArrayList<f> arrayList = this.cPi.get(aoi);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f lv = lv(str);
            boolean z = false;
            if (lv != null) {
                if (lv.cPm != i) {
                    lv.cPm = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cPm = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(aoi, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject aos;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (aos = fVar.aos()) != null) {
                    jSONArray.put(aos);
                    arrayList2.add(fVar);
                }
            }
            if (!v.v(arrayList2)) {
                this.cPi.put(str, arrayList2);
                if (!this.cPc) {
                    aop();
                } else {
                    lw(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f lv(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cPi.get(aoi());
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

    private void lw(String str) {
        l<String> aok = aok();
        if (aok != null) {
            aok.f("frs_sortType", str);
        }
    }

    public void aop() {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aor */
            public l<String> doInBackground() {
                return d.this.aok();
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
                        /* renamed from: aU */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.cPi.put(d.this.aoi(), d.this.lu(str2));
                            }
                            d.this.cPc = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aok() {
        return com.baidu.tbadk.core.c.a.td().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> lu(String str) {
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

    public void aoq() {
        lw("");
        this.cPi.remove(aoi());
    }
}
