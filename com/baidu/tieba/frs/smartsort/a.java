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
    private static volatile a dTI;
    private boolean dTG = false;
    private final HashMap<String, ArrayList<e>> dTH = new HashMap<>();

    private a() {
    }

    public static a azF() {
        if (dTI == null) {
            synchronized (a.class) {
                if (dTI == null) {
                    dTI = new a();
                }
            }
        }
        return dTI;
    }

    public String azG() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mk(String str) {
        e ml;
        ml = ml(str);
        return ml != null ? ml.dTQ : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String azG = azG();
            ArrayList<e> arrayList = this.dTH.get(azG);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e ml = ml(str);
            boolean z = false;
            if (ml != null) {
                if (ml.dTQ != j) {
                    ml.dTQ = j;
                    z = true;
                }
            } else {
                e eVar = new e();
                eVar.forumName = str;
                eVar.dTQ = j;
                arrayList2.add(eVar);
                z = true;
            }
            if (z) {
                d(azG, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject azP;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (azP = eVar.azP()) != null) {
                    jSONArray.put(azP);
                    arrayList2.add(eVar);
                }
            }
            if (!v.E(arrayList2)) {
                this.dTH.put(str, arrayList2);
                if (!this.dTG) {
                    azH();
                } else {
                    mm(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e ml(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dTH.get(azG());
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

    private void mm(String str) {
        l<String> azI = azI();
        if (azI != null) {
            azI.f("frs_smart_sort_last_time", str);
        }
    }

    public void azH() {
        l<String> azI = azI();
        if (azI != null) {
            azI.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList mn = a.this.mn(str2);
                        a.this.dTH.put(a.this.azG(), mn);
                    }
                    a.this.dTG = true;
                }
            });
        }
    }

    private l<String> azI() {
        return com.baidu.tbadk.core.c.a.AQ().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> mn(String str) {
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
