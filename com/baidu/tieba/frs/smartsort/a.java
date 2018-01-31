package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static volatile a dQJ;
    private boolean dQH = false;
    private final HashMap<String, ArrayList<e>> dQI = new HashMap<>();

    private a() {
    }

    public static a ayE() {
        if (dQJ == null) {
            synchronized (a.class) {
                if (dQJ == null) {
                    dQJ = new a();
                }
            }
        }
        return dQJ;
    }

    public String ayF() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long lY(String str) {
        e lZ;
        lZ = lZ(str);
        return lZ != null ? lZ.lastTime : 0L;
    }

    public synchronized void m(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ayF = ayF();
            ArrayList<e> arrayList = this.dQI.get(ayF);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e lZ = lZ(str);
            boolean z = false;
            if (lZ != null) {
                if (lZ.lastTime != j) {
                    lZ.lastTime = j;
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
                d(ayF, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject ayO;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (ayO = eVar.ayO()) != null) {
                    jSONArray.put(ayO);
                    arrayList2.add(eVar);
                }
            }
            if (!v.E(arrayList2)) {
                this.dQI.put(str, arrayList2);
                if (!this.dQH) {
                    ayG();
                } else {
                    ma(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e lZ(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dQI.get(ayF());
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

    private void ma(String str) {
        l<String> ayH = ayH();
        if (ayH != null) {
            ayH.f("frs_smart_sort_last_time", str);
        }
    }

    public void ayG() {
        l<String> ayH = ayH();
        if (ayH != null) {
            ayH.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aW */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList mb = a.this.mb(str2);
                        a.this.dQI.put(a.this.ayF(), mb);
                    }
                    a.this.dQH = true;
                }
            });
        }
    }

    private l<String> ayH() {
        return com.baidu.tbadk.core.c.a.Ax().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> mb(String str) {
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
