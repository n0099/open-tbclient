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
    private static volatile a cFx;
    private boolean cFv = false;
    private final HashMap<String, ArrayList<e>> cFw = new HashMap<>();

    private a() {
    }

    public static a alh() {
        if (cFx == null) {
            synchronized (a.class) {
                if (cFx == null) {
                    cFx = new a();
                }
            }
        }
        return cFx;
    }

    public String ali() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kO(String str) {
        e kP;
        kP = kP(str);
        return kP != null ? kP.lastTime : 0L;
    }

    public synchronized void j(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ali = ali();
            ArrayList<e> arrayList = this.cFw.get(ali);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e kP = kP(str);
            boolean z = false;
            if (kP != null) {
                if (kP.lastTime != j) {
                    kP.lastTime = j;
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
                d(ali, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject als;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (als = eVar.als()) != null) {
                    jSONArray.put(als);
                    arrayList2.add(eVar);
                }
            }
            if (!v.u(arrayList2)) {
                this.cFw.put(str, arrayList2);
                if (!this.cFv) {
                    alj();
                } else {
                    kQ(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e kP(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cFw.get(ali());
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

    private void kQ(String str) {
        l<String> alk = alk();
        if (alk != null) {
            alk.f("frs_smart_sort_last_time", str);
        }
    }

    public void alj() {
        l<String> alk = alk();
        if (alk != null) {
            alk.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aY */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList kR = a.this.kR(str2);
                        a.this.cFw.put(a.this.ali(), kR);
                    }
                    a.this.cFv = true;
                }
            });
        }
    }

    private l<String> alk() {
        return com.baidu.tbadk.core.c.a.sX().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> kR(String str) {
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
