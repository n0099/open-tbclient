package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static volatile a eeG;
    private boolean eeE = false;
    private final HashMap<String, ArrayList<d>> eeF = new HashMap<>();

    private a() {
    }

    public static a aHN() {
        if (eeG == null) {
            synchronized (a.class) {
                if (eeG == null) {
                    eeG = new a();
                }
            }
        }
        return eeG;
    }

    public String aHO() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long pa(String str) {
        d pb;
        pb = pb(str);
        return pb != null ? pb.lastTime : 0L;
    }

    public synchronized void o(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aHO = aHO();
            ArrayList<d> arrayList = this.eeF.get(aHO);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d pb = pb(str);
            boolean z = false;
            if (pb != null) {
                if (pb.lastTime != j) {
                    pb.lastTime = j;
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
                e(aHO, arrayList2);
            }
        }
    }

    private synchronized void e(String str, ArrayList<d> arrayList) {
        JSONObject aHV;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aHV = dVar.aHV()) != null) {
                    jSONArray.put(aHV);
                    arrayList2.add(dVar);
                }
            }
            if (!v.I(arrayList2)) {
                this.eeF.put(str, arrayList2);
                if (!this.eeE) {
                    aHP();
                } else {
                    pc(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d pb(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.eeF.get(aHO());
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

    private void pc(final String str) {
        y.a(new x<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.x
            /* renamed from: aHR */
            public l<String> doInBackground() {
                l aHQ = a.this.aHQ();
                if (aHQ != null) {
                    aHQ.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aHP() {
        y.a(new x<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.x
            /* renamed from: aHR */
            public l<String> doInBackground() {
                l aHQ = a.this.aHQ();
                if (aHQ != null) {
                    String str = (String) aHQ.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList pd = a.this.pd(str);
                        a.this.eeF.put(a.this.aHO(), pd);
                    }
                    a.this.eeE = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aHQ() {
        return com.baidu.tbadk.core.c.a.BO().ao("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> pd(String str) {
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
