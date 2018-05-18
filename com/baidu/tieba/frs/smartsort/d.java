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
/* loaded from: classes2.dex */
public class d {
    private static volatile d dpm;
    private boolean dpe = false;
    private final HashMap<String, ArrayList<f>> dpl = new HashMap<>();

    private d() {
    }

    public static d auC() {
        if (dpm == null) {
            synchronized (d.class) {
                if (dpm == null) {
                    dpm = new d();
                }
            }
        }
        return dpm;
    }

    public String auw() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void i(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String auw = auw();
            ArrayList<f> arrayList = this.dpl.get(auw);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f mt = mt(str);
            boolean z = false;
            if (mt != null) {
                if (mt.dpq != i) {
                    mt.dpq = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.dpq = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(auw, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject auF;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (auF = fVar.auF()) != null) {
                    jSONArray.put(auF);
                    arrayList2.add(fVar);
                }
            }
            if (!v.w(arrayList2)) {
                this.dpl.put(str, arrayList2);
                if (!this.dpe) {
                    auD();
                } else {
                    mu(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f mt(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.dpl.get(auw());
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

    private void mu(String str) {
        l<String> auy = auy();
        if (auy != null) {
            auy.f("frs_sortType", str);
        }
    }

    public void auD() {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: auz */
            public l<String> doInBackground() {
                return d.this.auy();
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
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.dpl.put(d.this.auw(), d.this.ms(str2));
                            }
                            d.this.dpe = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> auy() {
        return com.baidu.tbadk.core.c.a.ty().O("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> ms(String str) {
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

    public void auE() {
        mu("");
        this.dpl.remove(auw());
    }
}
