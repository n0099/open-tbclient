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
    private static volatile a cPe;
    private boolean cPc = false;
    private final HashMap<String, ArrayList<e>> cPd = new HashMap<>();

    private a() {
    }

    public static a aoh() {
        if (cPe == null) {
            synchronized (a.class) {
                if (cPe == null) {
                    cPe = new a();
                }
            }
        }
        return cPe;
    }

    public String aoi() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long lr(String str) {
        e ls;
        ls = ls(str);
        return ls != null ? ls.lastTime : 0L;
    }

    public synchronized void k(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aoi = aoi();
            ArrayList<e> arrayList = this.cPd.get(aoi);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e ls = ls(str);
            boolean z = false;
            if (ls != null) {
                if (ls.lastTime != j) {
                    ls.lastTime = j;
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
                d(aoi, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject aos;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (aos = eVar.aos()) != null) {
                    jSONArray.put(aos);
                    arrayList2.add(eVar);
                }
            }
            if (!v.v(arrayList2)) {
                this.cPd.put(str, arrayList2);
                if (!this.cPc) {
                    aoj();
                } else {
                    lt(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e ls(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cPd.get(aoi());
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

    private void lt(String str) {
        l<String> aok = aok();
        if (aok != null) {
            aok.f("frs_smart_sort_last_time", str);
        }
    }

    public void aoj() {
        l<String> aok = aok();
        if (aok != null) {
            aok.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aU */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList lu = a.this.lu(str2);
                        a.this.cPd.put(a.this.aoi(), lu);
                    }
                    a.this.cPc = true;
                }
            });
        }
    }

    private l<String> aok() {
        return com.baidu.tbadk.core.c.a.td().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> lu(String str) {
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
