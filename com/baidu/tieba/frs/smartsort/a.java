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
    private static volatile a cxw;
    private boolean cxu = false;
    private final HashMap<String, ArrayList<e>> cxv = new HashMap<>();

    private a() {
    }

    public static a ajo() {
        if (cxw == null) {
            synchronized (a.class) {
                if (cxw == null) {
                    cxw = new a();
                }
            }
        }
        return cxw;
    }

    public String ajp() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kA(String str) {
        e kB;
        kB = kB(str);
        return kB != null ? kB.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ajp = ajp();
            ArrayList<e> arrayList = this.cxv.get(ajp);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e kB = kB(str);
            boolean z = false;
            if (kB != null) {
                if (kB.lastTime != j) {
                    kB.lastTime = j;
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
                d(ajp, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject ajy;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (ajy = eVar.ajy()) != null) {
                    jSONArray.put(ajy);
                    arrayList2.add(eVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cxv.put(str, arrayList2);
                if (!this.cxu) {
                    ajq();
                } else {
                    kC(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e kB(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cxv.get(ajp());
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

    private void kC(String str) {
        l<String> ajr = ajr();
        if (ajr != null) {
            ajr.l("frs_smart_sort_last_time", str);
        }
    }

    public void ajq() {
        l<String> ajr = ajr();
        if (ajr != null) {
            ajr.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aV */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        ArrayList kD = a.this.kD(str2);
                        a.this.cxv.put(a.this.ajp(), kD);
                    }
                    a.this.cxu = true;
                }
            });
        }
    }

    private l<String> ajr() {
        return com.baidu.tbadk.core.c.a.to().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> kD(String str) {
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
