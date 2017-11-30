package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a cYt;
    private boolean cYr = false;
    private final HashMap<String, ArrayList<e>> cYs = new HashMap<>();

    private a() {
    }

    public static a aqb() {
        if (cYt == null) {
            synchronized (a.class) {
                if (cYt == null) {
                    cYt = new a();
                }
            }
        }
        return cYt;
    }

    public String aqc() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long lA(String str) {
        e lB;
        lB = lB(str);
        return lB != null ? lB.lastTime : 0L;
    }

    public synchronized void m(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aqc = aqc();
            ArrayList<e> arrayList = this.cYs.get(aqc);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e lB = lB(str);
            boolean z = false;
            if (lB != null) {
                if (lB.lastTime != j) {
                    lB.lastTime = j;
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
                d(aqc, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject aqm;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (aqm = eVar.aqm()) != null) {
                    jSONArray.put(aqm);
                    arrayList2.add(eVar);
                }
            }
            if (!v.w(arrayList2)) {
                this.cYs.put(str, arrayList2);
                if (!this.cYr) {
                    aqd();
                } else {
                    lC(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e lB(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cYs.get(aqc());
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

    private void lC(String str) {
        l<String> aqe = aqe();
        if (aqe != null) {
            aqe.f("frs_smart_sort_last_time", str);
        }
    }

    public void aqd() {
        l<String> aqe = aqe();
        if (aqe != null) {
            aqe.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList lD = a.this.lD(str2);
                        a.this.cYs.put(a.this.aqc(), lD);
                    }
                    a.this.cYr = true;
                }
            });
        }
    }

    private l<String> aqe() {
        return com.baidu.tbadk.core.c.a.tg().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> lD(String str) {
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
