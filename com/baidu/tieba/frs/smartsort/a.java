package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static volatile a dBM;
    private boolean dBK = false;
    private final HashMap<String, ArrayList<d>> dBL = new HashMap<>();

    private a() {
    }

    public static a azo() {
        if (dBM == null) {
            synchronized (a.class) {
                if (dBM == null) {
                    dBM = new a();
                }
            }
        }
        return dBM;
    }

    public String azp() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mX(String str) {
        d mY;
        mY = mY(str);
        return mY != null ? mY.lastTime : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String azp = azp();
            ArrayList<d> arrayList = this.dBL.get(azp);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d mY = mY(str);
            boolean z = false;
            if (mY != null) {
                if (mY.lastTime != j) {
                    mY.lastTime = j;
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
                d(azp, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<d> arrayList) {
        JSONObject azv;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (azv = dVar.azv()) != null) {
                    jSONArray.put(azv);
                    arrayList2.add(dVar);
                }
            }
            if (!w.A(arrayList2)) {
                this.dBL.put(str, arrayList2);
                if (!this.dBK) {
                    azq();
                } else {
                    mZ(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d mY(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.dBL.get(azp());
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

    private void mZ(final String str) {
        com.baidu.tbadk.util.w.a(new v<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: azs */
            public l<String> doInBackground() {
                l azr = a.this.azr();
                if (azr != null) {
                    azr.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void azq() {
        com.baidu.tbadk.util.w.a(new v<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: azs */
            public l<String> doInBackground() {
                l azr = a.this.azr();
                if (azr != null) {
                    String str = (String) azr.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList na = a.this.na(str);
                        a.this.dBL.put(a.this.azp(), na);
                    }
                    a.this.dBK = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> azr() {
        return com.baidu.tbadk.core.c.a.xj().R("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> na(String str) {
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
