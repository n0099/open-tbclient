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
    private static volatile a dTz;
    private boolean dTx = false;
    private final HashMap<String, ArrayList<d>> dTy = new HashMap<>();

    private a() {
    }

    public static a aFt() {
        if (dTz == null) {
            synchronized (a.class) {
                if (dTz == null) {
                    dTz = new a();
                }
            }
        }
        return dTz;
    }

    public String aFu() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long og(String str) {
        d oh;
        oh = oh(str);
        return oh != null ? oh.lastTime : 0L;
    }

    public synchronized void o(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aFu = aFu();
            ArrayList<d> arrayList = this.dTy.get(aFu);
            ArrayList<d> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            d oh = oh(str);
            boolean z = false;
            if (oh != null) {
                if (oh.lastTime != j) {
                    oh.lastTime = j;
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
                e(aFu, arrayList2);
            }
        }
    }

    private synchronized void e(String str, ArrayList<d> arrayList) {
        JSONObject aFB;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.forumName) && (aFB = dVar.aFB()) != null) {
                    jSONArray.put(aFB);
                    arrayList2.add(dVar);
                }
            }
            if (!v.J(arrayList2)) {
                this.dTy.put(str, arrayList2);
                if (!this.dTx) {
                    aFv();
                } else {
                    oi(jSONArray.toString());
                }
            }
        }
    }

    private synchronized d oh(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<d> arrayList = this.dTy.get(aFu());
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

    private void oi(final String str) {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aFx */
            public l<String> doInBackground() {
                l aFw = a.this.aFw();
                if (aFw != null) {
                    aFw.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aFv() {
        x.a(new w<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aFx */
            public l<String> doInBackground() {
                l aFw = a.this.aFw();
                if (aFw != null) {
                    String str = (String) aFw.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList oj = a.this.oj(str);
                        a.this.dTy.put(a.this.aFu(), oj);
                    }
                    a.this.dTx = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> aFw() {
        return com.baidu.tbadk.core.c.a.Aq().ak("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> oj(String str) {
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
