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
    private static volatile a fsW;
    private boolean fsU = false;
    private final HashMap<String, ArrayList<d>> fsV = new HashMap<>();

    private a() {
    }

    public static a bid() {
        if (fsW == null) {
            synchronized (a.class) {
                if (fsW == null) {
                    fsW = new a();
                }
            }
        }
        return fsW;
    }

    public String bie() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long vH(String str) {
        d vI;
        vI = vI(str);
        return vI != null ? vI.lastTime : 0L;
    }

    public synchronized void r(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String bie = bie();
            ArrayList<d> arrayList = this.fsV.get(bie);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d vI = vI(str);
            boolean z = false;
            if (vI != null) {
                if (vI.lastTime != j) {
                    vI.lastTime = j;
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
                d(bie, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<d> arrayList) {
        JSONObject bil;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (bil = dVar.bil()) != null) {
                    jSONArray.put(bil);
                    arrayList2.add(dVar);
                }
            }
            if (!v.T(arrayList2)) {
                this.fsV.put(str, arrayList2);
                if (!this.fsU) {
                    bif();
                } else {
                    vJ(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d vI(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.fsV.get(bie());
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

    private void vJ(final String str) {
        aa.a(new z<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bih */
            public l<String> doInBackground() {
                l big = a.this.big();
                if (big != null) {
                    big.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void bif() {
        aa.a(new z<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bih */
            public l<String> doInBackground() {
                l big = a.this.big();
                if (big != null) {
                    String str = (String) big.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList vK = a.this.vK(str);
                        a.this.fsV.put(a.this.bie(), vK);
                    }
                    a.this.fsU = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> big() {
        return com.baidu.tbadk.core.c.a.aaW().bv("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> vK(String str) {
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
