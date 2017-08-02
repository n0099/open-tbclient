package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a cub;
    private boolean ctZ = false;
    private final HashMap<String, ArrayList<e>> cua = new HashMap<>();

    private a() {
    }

    public static a aiB() {
        if (cub == null) {
            synchronized (a.class) {
                if (cub == null) {
                    cub = new a();
                }
            }
        }
        return cub;
    }

    public String aiC() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kp(String str) {
        e kq;
        kq = kq(str);
        return kq != null ? kq.lastTime : 0L;
    }

    public synchronized void h(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aiC = aiC();
            ArrayList<e> arrayList = this.cua.get(aiC);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e kq = kq(str);
            boolean z = false;
            if (kq != null) {
                if (kq.lastTime != j) {
                    kq.lastTime = j;
                    z = true;
                }
            } else {
                e eVar = new e();
                eVar.forumName = str;
                eVar.lastTime = j;
                arrayList2.add(eVar);
                z = true;
            }
            if (z) {
                d(aiC, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject aiL;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (aiL = eVar.aiL()) != null) {
                    jSONArray.put(aiL);
                    arrayList2.add(eVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cua.put(str, arrayList2);
                if (!this.ctZ) {
                    aiD();
                } else {
                    kr(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e kq(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cua.get(aiC());
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

    private void kr(String str) {
        l<String> aiE = aiE();
        if (aiE != null) {
            aiE.l("frs_smart_sort_last_time", str);
        }
    }

    public void aiD() {
        l<String> aiE = aiE();
        if (aiE != null) {
            aiE.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aT */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        ArrayList ks = a.this.ks(str2);
                        a.this.cua.put(a.this.aiC(), ks);
                    }
                    a.this.ctZ = true;
                }
            });
        }
    }

    private l<String> aiE() {
        return com.baidu.tbadk.core.c.a.td().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> ks(String str) {
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
