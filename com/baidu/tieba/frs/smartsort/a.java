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
    private static volatile a dEy;
    private boolean dEw = false;
    private final HashMap<String, ArrayList<d>> dEx = new HashMap<>();

    private a() {
    }

    public static a azU() {
        if (dEy == null) {
            synchronized (a.class) {
                if (dEy == null) {
                    dEy = new a();
                }
            }
        }
        return dEy;
    }

    public String azV() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mW(String str) {
        d mX;
        mX = mX(str);
        return mX != null ? mX.lastTime : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String azV = azV();
            ArrayList<d> arrayList = this.dEx.get(azV);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d mX = mX(str);
            boolean z = false;
            if (mX != null) {
                if (mX.lastTime != j) {
                    mX.lastTime = j;
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
                d(azV, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<d> arrayList) {
        JSONObject aAc;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aAc = dVar.aAc()) != null) {
                    jSONArray.put(aAc);
                    arrayList2.add(dVar);
                }
            }
            if (!w.z(arrayList2)) {
                this.dEx.put(str, arrayList2);
                if (!this.dEw) {
                    azW();
                } else {
                    mY(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d mX(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.dEx.get(azV());
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

    private void mY(final String str) {
        v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: azY */
            public l<String> doInBackground() {
                l azX = a.this.azX();
                if (azX != null) {
                    azX.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void azW() {
        v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: azY */
            public l<String> doInBackground() {
                l azX = a.this.azX();
                if (azX != null) {
                    String str = (String) azX.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList mZ = a.this.mZ(str);
                        a.this.dEx.put(a.this.azV(), mZ);
                    }
                    a.this.dEw = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> azX() {
        return com.baidu.tbadk.core.c.a.xb().Q("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> mZ(String str) {
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
