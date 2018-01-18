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
    private static volatile a dQo;
    private boolean dQm = false;
    private final HashMap<String, ArrayList<e>> dQn = new HashMap<>();

    private a() {
    }

    public static a ayz() {
        if (dQo == null) {
            synchronized (a.class) {
                if (dQo == null) {
                    dQo = new a();
                }
            }
        }
        return dQo;
    }

    public String ayA() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long lR(String str) {
        e lS;
        lS = lS(str);
        return lS != null ? lS.lastTime : 0L;
    }

    public synchronized void m(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ayA = ayA();
            ArrayList<e> arrayList = this.dQn.get(ayA);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e lS = lS(str);
            boolean z = false;
            if (lS != null) {
                if (lS.lastTime != j) {
                    lS.lastTime = j;
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
                d(ayA, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject ayJ;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (ayJ = eVar.ayJ()) != null) {
                    jSONArray.put(ayJ);
                    arrayList2.add(eVar);
                }
            }
            if (!v.E(arrayList2)) {
                this.dQn.put(str, arrayList2);
                if (!this.dQm) {
                    ayB();
                } else {
                    lT(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e lS(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dQn.get(ayA());
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

    private void lT(String str) {
        l<String> ayC = ayC();
        if (ayC != null) {
            ayC.f("frs_smart_sort_last_time", str);
        }
    }

    public void ayB() {
        l<String> ayC = ayC();
        if (ayC != null) {
            ayC.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList lU = a.this.lU(str2);
                        a.this.dQn.put(a.this.ayA(), lU);
                    }
                    a.this.dQm = true;
                }
            });
        }
    }

    private l<String> ayC() {
        return com.baidu.tbadk.core.c.a.Aw().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> lU(String str) {
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
