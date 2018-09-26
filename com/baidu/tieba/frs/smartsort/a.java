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
/* loaded from: classes2.dex */
public class a {
    private static volatile a dLC;
    private boolean dLA = false;
    private final HashMap<String, ArrayList<d>> dLB = new HashMap<>();

    private a() {
    }

    public static a aCa() {
        if (dLC == null) {
            synchronized (a.class) {
                if (dLC == null) {
                    dLC = new a();
                }
            }
        }
        return dLC;
    }

    public String aCb() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long nD(String str) {
        d nE;
        nE = nE(str);
        return nE != null ? nE.lastTime : 0L;
    }

    public synchronized void n(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aCb = aCb();
            ArrayList<d> arrayList = this.dLB.get(aCb);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d nE = nE(str);
            boolean z = false;
            if (nE != null) {
                if (nE.lastTime != j) {
                    nE.lastTime = j;
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
                e(aCb, arrayList2);
            }
        }
    }

    private synchronized void e(String str, ArrayList<d> arrayList) {
        JSONObject aCi;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aCi = dVar.aCi()) != null) {
                    jSONArray.put(aCi);
                    arrayList2.add(dVar);
                }
            }
            if (!v.z(arrayList2)) {
                this.dLB.put(str, arrayList2);
                if (!this.dLA) {
                    aCc();
                } else {
                    nF(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d nE(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.dLB.get(aCb());
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

    private void nF(final String str) {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aCe */
            public l<String> doInBackground() {
                l aCd = a.this.aCd();
                if (aCd != null) {
                    aCd.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aCc() {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aCe */
            public l<String> doInBackground() {
                l aCd = a.this.aCd();
                if (aCd != null) {
                    String str = (String) aCd.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList nG = a.this.nG(str);
                        a.this.dLB.put(a.this.aCb(), nG);
                    }
                    a.this.dLA = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aCd() {
        return com.baidu.tbadk.core.c.a.yh().X("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> nG(String str) {
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
