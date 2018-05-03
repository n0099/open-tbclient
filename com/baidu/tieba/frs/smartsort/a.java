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
    private static volatile a dnY;
    private boolean dnW = false;
    private final HashMap<String, ArrayList<e>> dnX = new HashMap<>();

    private a() {
    }

    public static a auw() {
        if (dnY == null) {
            synchronized (a.class) {
                if (dnY == null) {
                    dnY = new a();
                }
            }
        }
        return dnY;
    }

    public String aux() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long mm(String str) {
        e mn;
        mn = mn(str);
        return mn != null ? mn.doh : 0L;
    }

    public synchronized void l(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aux = aux();
            ArrayList<e> arrayList = this.dnX.get(aux);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e mn = mn(str);
            boolean z = false;
            if (mn != null) {
                if (mn.doh != j) {
                    mn.doh = j;
                    z = true;
                }
            } else {
                e eVar = new e();
                eVar.forumName = str;
                eVar.doh = j;
                arrayList2.add(eVar);
                z = true;
            }
            if (z) {
                d(aux, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject auG;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (auG = eVar.auG()) != null) {
                    jSONArray.put(auG);
                    arrayList2.add(eVar);
                }
            }
            if (!v.w(arrayList2)) {
                this.dnX.put(str, arrayList2);
                if (!this.dnW) {
                    auy();
                } else {
                    mo(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e mn(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dnX.get(aux());
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

    private void mo(String str) {
        l<String> auz = auz();
        if (auz != null) {
            auz.f("frs_smart_sort_last_time", str);
        }
    }

    public void auy() {
        l<String> auz = auz();
        if (auz != null) {
            auz.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList mp = a.this.mp(str2);
                        a.this.dnX.put(a.this.aux(), mp);
                    }
                    a.this.dnW = true;
                }
            });
        }
    }

    private l<String> auz() {
        return com.baidu.tbadk.core.c.a.tz().O("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> mp(String str) {
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
