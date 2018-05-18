package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static volatile a dpg;
    private boolean dpe = false;
    private final HashMap<String, ArrayList<e>> dpf = new HashMap<>();

    private a() {
    }

    public static a auv() {
        if (dpg == null) {
            synchronized (a.class) {
                if (dpg == null) {
                    dpg = new a();
                }
            }
        }
        return dpg;
    }

    public String auw() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mp(String str) {
        e mq;
        mq = mq(str);
        return mq != null ? mq.dpp : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String auw = auw();
            ArrayList<e> arrayList = this.dpf.get(auw);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e mq = mq(str);
            boolean z = false;
            if (mq != null) {
                if (mq.dpp != j) {
                    mq.dpp = j;
                    z = true;
                }
            } else {
                e eVar = new e();
                eVar.forumName = str;
                eVar.dpp = j;
                arrayList2.add(eVar);
                z = true;
            }
            if (z) {
                d(auw, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject auF;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (auF = eVar.auF()) != null) {
                    jSONArray.put(auF);
                    arrayList2.add(eVar);
                }
            }
            if (!v.w(arrayList2)) {
                this.dpf.put(str, arrayList2);
                if (!this.dpe) {
                    aux();
                } else {
                    mr(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e mq(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dpf.get(auw());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        eVar = null;
                        break;
                    }
                    eVar = arrayList.get(i2);
                    if (str.equalsIgnoreCase(eVar.forumName)) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                eVar = null;
            }
        } else {
            eVar = null;
        }
        return eVar;
    }

    private void mr(final String str) {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: auz */
            public l<String> doInBackground() {
                l auy = a.this.auy();
                if (auy != null) {
                    auy.e("frs_smart_sort_last_time", str);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void aux() {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: auz */
            public l<String> doInBackground() {
                l auy = a.this.auy();
                if (auy != null) {
                    String str = (String) auy.get("frs_smart_sort_last_time");
                    if (str != null) {
                        ArrayList ms = a.this.ms(str);
                        a.this.dpf.put(a.this.auw(), ms);
                    }
                    a.this.dpe = true;
                    return null;
                }
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> auy() {
        return com.baidu.tbadk.core.c.a.ty().O("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> ms(String str) {
        ArrayList<e> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new e(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
