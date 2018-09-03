package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static volatile a dEv;
    private boolean dEt = false;
    private final HashMap<String, ArrayList<d>> dEu = new HashMap<>();

    private a() {
    }

    public static a azR() {
        if (dEv == null) {
            synchronized (a.class) {
                if (dEv == null) {
                    dEv = new a();
                }
            }
        }
        return dEv;
    }

    public String azS() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mY(String str) {
        d mZ;
        mZ = mZ(str);
        return mZ != null ? mZ.lastTime : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String azS = azS();
            ArrayList<d> arrayList = this.dEu.get(azS);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d mZ = mZ(str);
            boolean z = false;
            if (mZ != null) {
                if (mZ.lastTime != j) {
                    mZ.lastTime = j;
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
                d(azS, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<d> arrayList) {
        JSONObject azZ;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (azZ = dVar.azZ()) != null) {
                    jSONArray.put(azZ);
                    arrayList2.add(dVar);
                }
            }
            if (!w.z(arrayList2)) {
                this.dEu.put(str, arrayList2);
                if (!this.dEt) {
                    azT();
                } else {
                    na(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d mZ(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.dEu.get(azS());
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

    private void na(final String str) {
        v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: azV */
            public l<String> doInBackground() {
                l azU = a.this.azU();
                if (azU != null) {
                    azU.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void azT() {
        v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: azV */
            public l<String> doInBackground() {
                l azU = a.this.azU();
                if (azU != null) {
                    String str = (String) azU.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList nb = a.this.nb(str);
                        a.this.dEu.put(a.this.azS(), nb);
                    }
                    a.this.dEt = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> azU() {
        return com.baidu.tbadk.core.c.a.xa().Q("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> nb(String str) {
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
