package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a fsH;
    private boolean fsF = false;
    private final HashMap<String, ArrayList<d>> fsG = new HashMap<>();

    private a() {
    }

    public static a bia() {
        if (fsH == null) {
            synchronized (a.class) {
                if (fsH == null) {
                    fsH = new a();
                }
            }
        }
        return fsH;
    }

    public String bib() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long vE(String str) {
        d vF;
        vF = vF(str);
        return vF != null ? vF.lastTime : 0L;
    }

    public synchronized void r(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String bib = bib();
            ArrayList<d> arrayList = this.fsG.get(bib);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d vF = vF(str);
            boolean z = false;
            if (vF != null) {
                if (vF.lastTime != j) {
                    vF.lastTime = j;
                    z = true;
                }
            } else {
                d dVar = new d();
                dVar.forumName = str;
                dVar.lastTime = j;
                arrayList2.add(dVar);
                z = true;
            }
            if (z) {
                d(bib, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<d> arrayList) {
        JSONObject bii;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (bii = dVar.bii()) != null) {
                    jSONArray.put(bii);
                    arrayList2.add(dVar);
                }
            }
            if (!v.T(arrayList2)) {
                this.fsG.put(str, arrayList2);
                if (!this.fsF) {
                    bic();
                } else {
                    vG(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d vF(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.fsG.get(bib());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        dVar = null;
                        break;
                    }
                    dVar = arrayList.get(i2);
                    if (str.equalsIgnoreCase(dVar.forumName)) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                dVar = null;
            }
        } else {
            dVar = null;
        }
        return dVar;
    }

    private void vG(final String str) {
        aa.a(new z<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bie */
            public l<String> doInBackground() {
                l bid = a.this.bid();
                if (bid != null) {
                    bid.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void bic() {
        aa.a(new z<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bie */
            public l<String> doInBackground() {
                l bid = a.this.bid();
                if (bid != null) {
                    String str = (String) bid.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList vH = a.this.vH(str);
                        a.this.fsG.put(a.this.bib(), vH);
                    }
                    a.this.fsF = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> bid() {
        return com.baidu.tbadk.core.c.a.aaT().bv("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> vH(String str) {
        ArrayList<d> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new d(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
