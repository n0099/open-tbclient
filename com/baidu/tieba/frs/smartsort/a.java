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
    private static volatile a dLM;
    private boolean dLK = false;
    private final HashMap<String, ArrayList<e>> dLL = new HashMap<>();

    private a() {
    }

    public static a axw() {
        if (dLM == null) {
            synchronized (a.class) {
                if (dLM == null) {
                    dLM = new a();
                }
            }
        }
        return dLM;
    }

    public String axx() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long lJ(String str) {
        e lK;
        lK = lK(str);
        return lK != null ? lK.lastTime : 0L;
    }

    public synchronized void m(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String axx = axx();
            ArrayList<e> arrayList = this.dLL.get(axx);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e lK = lK(str);
            boolean z = false;
            if (lK != null) {
                if (lK.lastTime != j) {
                    lK.lastTime = j;
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
                d(axx, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject axG;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (axG = eVar.axG()) != null) {
                    jSONArray.put(axG);
                    arrayList2.add(eVar);
                }
            }
            if (!v.G(arrayList2)) {
                this.dLL.put(str, arrayList2);
                if (!this.dLK) {
                    axy();
                } else {
                    lL(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e lK(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.dLL.get(axx());
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

    private void lL(String str) {
        l<String> axz = axz();
        if (axz != null) {
            axz.f("frs_smart_sort_last_time", str);
        }
    }

    public void axy() {
        l<String> axz = axz();
        if (axz != null) {
            axz.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aX */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList lM = a.this.lM(str2);
                        a.this.dLL.put(a.this.axx(), lM);
                    }
                    a.this.dLK = true;
                }
            });
        }
    }

    private l<String> axz() {
        return com.baidu.tbadk.core.c.a.AE().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> lM(String str) {
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
