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
    private static volatile a dTN;
    private boolean dTL = false;
    private final HashMap<String, ArrayList<e>> dTM = new HashMap<>();

    private a() {
    }

    public static a azH() {
        if (dTN == null) {
            synchronized (a.class) {
                if (dTN == null) {
                    dTN = new a();
                }
            }
        }
        return dTN;
    }

    public String azI() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mk(String str) {
        e ml;
        ml = ml(str);
        return ml != null ? ml.dTV : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String azI = azI();
            ArrayList<e> arrayList = this.dTM.get(azI);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e ml = ml(str);
            boolean z = false;
            if (ml != null) {
                if (ml.dTV != j) {
                    ml.dTV = j;
                    z = true;
                }
            } else {
                e eVar = new e();
                eVar.forumName = str;
                eVar.dTV = j;
                arrayList2.add(eVar);
                z = true;
            }
            if (z) {
                d(azI, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject azR;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (azR = eVar.azR()) != null) {
                    jSONArray.put(azR);
                    arrayList2.add(eVar);
                }
            }
            if (!v.E(arrayList2)) {
                this.dTM.put(str, arrayList2);
                if (!this.dTL) {
                    azJ();
                } else {
                    mm(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e ml(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dTM.get(azI());
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
        l<String> azK = azK();
        if (azK != null) {
            azK.f("frs_smart_sort_last_time", str);
        }
    }

    public void azJ() {
        l<String> azK = azK();
        if (azK != null) {
            azK.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList mn = a.this.mn(str2);
                        a.this.dTM.put(a.this.azI(), mn);
                    }
                    a.this.dTL = true;
                }
            });
        }
    }

    private l<String> azK() {
        return com.baidu.tbadk.core.c.a.AR().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
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
