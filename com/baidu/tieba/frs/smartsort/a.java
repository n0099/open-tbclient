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
    private static volatile a cEQ;
    private boolean cEO = false;
    private final HashMap<String, ArrayList<e>> cEP = new HashMap<>();

    private a() {
    }

    public static a ali() {
        if (cEQ == null) {
            synchronized (a.class) {
                if (cEQ == null) {
                    cEQ = new a();
                }
            }
        }
        return cEQ;
    }

    public String alj() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kS(String str) {
        e kT;
        kT = kT(str);
        return kT != null ? kT.lastTime : 0L;
    }

    public synchronized void j(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String alj = alj();
            ArrayList<e> arrayList = this.cEP.get(alj);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e kT = kT(str);
            boolean z = false;
            if (kT != null) {
                if (kT.lastTime != j) {
                    kT.lastTime = j;
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
                d(alj, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject alt;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (alt = eVar.alt()) != null) {
                    jSONArray.put(alt);
                    arrayList2.add(eVar);
                }
            }
            if (!v.v(arrayList2)) {
                this.cEP.put(str, arrayList2);
                if (!this.cEO) {
                    alk();
                } else {
                    kU(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e kT(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cEP.get(alj());
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

    private void kU(String str) {
        l<String> all = all();
        if (all != null) {
            all.f("frs_smart_sort_last_time", str);
        }
    }

    public void alk() {
        l<String> all = all();
        if (all != null) {
            all.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aZ */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList kV = a.this.kV(str2);
                        a.this.cEP.put(a.this.alj(), kV);
                    }
                    a.this.cEO = true;
                }
            });
        }
    }

    private l<String> all() {
        return com.baidu.tbadk.core.c.a.tk().O("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> kV(String str) {
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
