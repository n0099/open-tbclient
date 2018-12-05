package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static volatile a ebi;
    private boolean ebg = false;
    private final HashMap<String, ArrayList<d>> ebh = new HashMap<>();

    private a() {
    }

    public static a aGB() {
        if (ebi == null) {
            synchronized (a.class) {
                if (ebi == null) {
                    ebi = new a();
                }
            }
        }
        return ebi;
    }

    public String aGC() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long oH(String str) {
        d oI;
        oI = oI(str);
        return oI != null ? oI.lastTime : 0L;
    }

    public synchronized void o(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aGC = aGC();
            ArrayList<d> arrayList = this.ebh.get(aGC);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d oI = oI(str);
            boolean z = false;
            if (oI != null) {
                if (oI.lastTime != j) {
                    oI.lastTime = j;
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
                e(aGC, arrayList2);
            }
        }
    }

    private synchronized void e(String str, ArrayList<d> arrayList) {
        JSONObject aGJ;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aGJ = dVar.aGJ()) != null) {
                    jSONArray.put(aGJ);
                    arrayList2.add(dVar);
                }
            }
            if (!v.I(arrayList2)) {
                this.ebh.put(str, arrayList2);
                if (!this.ebg) {
                    aGD();
                } else {
                    oJ(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d oI(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.ebh.get(aGC());
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

    private void oJ(final String str) {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aGF */
            public l<String> doInBackground() {
                l aGE = a.this.aGE();
                if (aGE != null) {
                    aGE.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aGD() {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aGF */
            public l<String> doInBackground() {
                l aGE = a.this.aGE();
                if (aGE != null) {
                    String str = (String) aGE.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList oK = a.this.oK(str);
                        a.this.ebh.put(a.this.aGC(), oK);
                    }
                    a.this.ebg = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aGE() {
        return com.baidu.tbadk.core.c.a.BB().an("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> oK(String str) {
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
