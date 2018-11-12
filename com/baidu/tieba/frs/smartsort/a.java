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
    private static volatile a dUF;
    private boolean dUD = false;
    private final HashMap<String, ArrayList<d>> dUE = new HashMap<>();

    private a() {
    }

    public static a aEP() {
        if (dUF == null) {
            synchronized (a.class) {
                if (dUF == null) {
                    dUF = new a();
                }
            }
        }
        return dUF;
    }

    public String aEQ() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long oh(String str) {
        d oi;
        oi = oi(str);
        return oi != null ? oi.lastTime : 0L;
    }

    public synchronized void n(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aEQ = aEQ();
            ArrayList<d> arrayList = this.dUE.get(aEQ);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d oi = oi(str);
            boolean z = false;
            if (oi != null) {
                if (oi.lastTime != j) {
                    oi.lastTime = j;
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
                e(aEQ, arrayList2);
            }
        }
    }

    private synchronized void e(String str, ArrayList<d> arrayList) {
        JSONObject aEX;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aEX = dVar.aEX()) != null) {
                    jSONArray.put(aEX);
                    arrayList2.add(dVar);
                }
            }
            if (!v.I(arrayList2)) {
                this.dUE.put(str, arrayList2);
                if (!this.dUD) {
                    aER();
                } else {
                    oj(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d oi(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.dUE.get(aEQ());
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

    private void oj(final String str) {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aET */
            public l<String> doInBackground() {
                l aES = a.this.aES();
                if (aES != null) {
                    aES.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aER() {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aET */
            public l<String> doInBackground() {
                l aES = a.this.aES();
                if (aES != null) {
                    String str = (String) aES.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList ok = a.this.ok(str);
                        a.this.dUE.put(a.this.aEQ(), ok);
                    }
                    a.this.dUD = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aES() {
        return com.baidu.tbadk.core.c.a.Ax().ak("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> ok(String str) {
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
