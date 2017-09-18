package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static volatile d cEV;
    private boolean cEO = false;
    private final HashMap<String, ArrayList<f>> cEU = new HashMap<>();

    private d() {
    }

    public static d alp() {
        if (cEV == null) {
            synchronized (d.class) {
                if (cEV == null) {
                    cEV = new d();
                }
            }
        }
        return cEV;
    }

    public String alj() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void g(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String alj = alj();
            ArrayList<f> arrayList = this.cEU.get(alj);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f kW = kW(str);
            boolean z = false;
            if (kW != null) {
                if (kW.cEY != i) {
                    kW.cEY = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cEY = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(alj, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject alt;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (alt = fVar.alt()) != null) {
                    jSONArray.put(alt);
                    arrayList2.add(fVar);
                }
            }
            if (!v.v(arrayList2)) {
                this.cEU.put(str, arrayList2);
                if (!this.cEO) {
                    alq();
                } else {
                    kX(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f kW(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cEU.get(alj());
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

    private void kX(String str) {
        l<String> all = all();
        if (all != null) {
            all.f("frs_sortType", str);
        }
    }

    public void alq() {
        u.a(new t<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: als */
            public l<String> doInBackground() {
                return d.this.all();
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
                        /* renamed from: aZ */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.cEU.put(d.this.alj(), d.this.kV(str2));
                            }
                            d.this.cEO = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> all() {
        return com.baidu.tbadk.core.c.a.tk().O("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> kV(String str) {
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

    public void alr() {
        kX("");
        this.cEU.remove(alj());
    }
}
