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
    private static volatile a edZ;
    private boolean edX = false;
    private final HashMap<String, ArrayList<d>> edY = new HashMap<>();

    private a() {
    }

    public static a aHq() {
        if (edZ == null) {
            synchronized (a.class) {
                if (edZ == null) {
                    edZ = new a();
                }
            }
        }
        return edZ;
    }

    public String aHr() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long oK(String str) {
        d oL;
        oL = oL(str);
        return oL != null ? oL.lastTime : 0L;
    }

    public synchronized void o(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aHr = aHr();
            ArrayList<d> arrayList = this.edY.get(aHr);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d oL = oL(str);
            boolean z = false;
            if (oL != null) {
                if (oL.lastTime != j) {
                    oL.lastTime = j;
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
                e(aHr, arrayList2);
            }
        }
    }

    private synchronized void e(String str, ArrayList<d> arrayList) {
        JSONObject aHy;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aHy = dVar.aHy()) != null) {
                    jSONArray.put(aHy);
                    arrayList2.add(dVar);
                }
            }
            if (!v.I(arrayList2)) {
                this.edY.put(str, arrayList2);
                if (!this.edX) {
                    aHs();
                } else {
                    oM(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d oL(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.edY.get(aHr());
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

    private void oM(final String str) {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aHu */
            public l<String> doInBackground() {
                l aHt = a.this.aHt();
                if (aHt != null) {
                    aHt.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aHs() {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aHu */
            public l<String> doInBackground() {
                l aHt = a.this.aHt();
                if (aHt != null) {
                    String str = (String) aHt.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList oN = a.this.oN(str);
                        a.this.edY.put(a.this.aHr(), oN);
                    }
                    a.this.edX = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aHt() {
        return com.baidu.tbadk.core.c.a.BB().an("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> oN(String str) {
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
