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
    private static volatile a cOK;
    private boolean cOI = false;
    private final HashMap<String, ArrayList<e>> cOJ = new HashMap<>();

    private a() {
    }

    public static a anS() {
        if (cOK == null) {
            synchronized (a.class) {
                if (cOK == null) {
                    cOK = new a();
                }
            }
        }
        return cOK;
    }

    public String anT() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long lp(String str) {
        e lq;
        lq = lq(str);
        return lq != null ? lq.lastTime : 0L;
    }

    public synchronized void k(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String anT = anT();
            ArrayList<e> arrayList = this.cOJ.get(anT);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e lq = lq(str);
            boolean z = false;
            if (lq != null) {
                if (lq.lastTime != j) {
                    lq.lastTime = j;
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
                d(anT, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject aod;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (aod = eVar.aod()) != null) {
                    jSONArray.put(aod);
                    arrayList2.add(eVar);
                }
            }
            if (!v.v(arrayList2)) {
                this.cOJ.put(str, arrayList2);
                if (!this.cOI) {
                    anU();
                } else {
                    lr(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e lq(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cOJ.get(anT());
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

    private void lr(String str) {
        l<String> anV = anV();
        if (anV != null) {
            anV.f("frs_smart_sort_last_time", str);
        }
    }

    public void anU() {
        l<String> anV = anV();
        if (anV != null) {
            anV.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aT */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList ls = a.this.ls(str2);
                        a.this.cOJ.put(a.this.anT(), ls);
                    }
                    a.this.cOI = true;
                }
            });
        }
    }

    private l<String> anV() {
        return com.baidu.tbadk.core.c.a.td().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> ls(String str) {
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
