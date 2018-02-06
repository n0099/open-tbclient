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
    private static volatile a dTU;
    private boolean dTS = false;
    private final HashMap<String, ArrayList<e>> dTT = new HashMap<>();

    private a() {
    }

    public static a azG() {
        if (dTU == null) {
            synchronized (a.class) {
                if (dTU == null) {
                    dTU = new a();
                }
            }
        }
        return dTU;
    }

    public String azH() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mk(String str) {
        e ml;
        ml = ml(str);
        return ml != null ? ml.dUc : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String azH = azH();
            ArrayList<e> arrayList = this.dTT.get(azH);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e ml = ml(str);
            boolean z = false;
            if (ml != null) {
                if (ml.dUc != j) {
                    ml.dUc = j;
                    z = true;
                }
            } else {
                e eVar = new e();
                eVar.forumName = str;
                eVar.dUc = j;
                arrayList2.add(eVar);
                z = true;
            }
            if (z) {
                d(azH, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject azQ;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (azQ = eVar.azQ()) != null) {
                    jSONArray.put(azQ);
                    arrayList2.add(eVar);
                }
            }
            if (!v.E(arrayList2)) {
                this.dTT.put(str, arrayList2);
                if (!this.dTS) {
                    azI();
                } else {
                    mm(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e ml(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dTT.get(azH());
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
        l<String> azJ = azJ();
        if (azJ != null) {
            azJ.f("frs_smart_sort_last_time", str);
        }
    }

    public void azI() {
        l<String> azJ = azJ();
        if (azJ != null) {
            azJ.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList mn = a.this.mn(str2);
                        a.this.dTT.put(a.this.azH(), mn);
                    }
                    a.this.dTS = true;
                }
            });
        }
    }

    private l<String> azJ() {
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
