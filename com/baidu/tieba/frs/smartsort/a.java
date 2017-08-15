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

    public static a aju() {
        if (cxw == null) {
            synchronized (a.class) {
                if (cxw == null) {
                    cxw = new a();
                }
            }
        }
        return cxw;
    }

    public String ajv() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kx(String str) {
        e ky;
        ky = ky(str);
        return ky != null ? ky.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ajv = ajv();
            ArrayList<e> arrayList = this.cxv.get(ajv);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e ky = ky(str);
            boolean z = false;
            if (ky != null) {
                if (ky.lastTime != j) {
                    ky.lastTime = j;
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
                d(ajv, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject ajE;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (ajE = eVar.ajE()) != null) {
                    jSONArray.put(ajE);
                    arrayList2.add(eVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cxv.put(str, arrayList2);
                if (!this.cxu) {
                    ajw();
                } else {
                    kz(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e ky(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cxv.get(ajv());
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

    private void kz(String str) {
        l<String> ajx = ajx();
        if (ajx != null) {
            ajx.l("frs_smart_sort_last_time", str);
        }
    }

    public void ajw() {
        l<String> ajx = ajx();
        if (ajx != null) {
            ajx.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aU */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        ArrayList kA = a.this.kA(str2);
                        a.this.cxv.put(a.this.ajv(), kA);
                    }
                    a.this.cxu = true;
                }
            });
        }
    }

    private l<String> ajx() {
        return com.baidu.tbadk.core.c.a.tn().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> kA(String str) {
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
