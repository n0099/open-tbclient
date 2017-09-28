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
    private static volatile a cFJ;
    private boolean cFH = false;
    private final HashMap<String, ArrayList<e>> cFI = new HashMap<>();

    private a() {
    }

    public static a alm() {
        if (cFJ == null) {
            synchronized (a.class) {
                if (cFJ == null) {
                    cFJ = new a();
                }
            }
        }
        return cFJ;
    }

    public String aln() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kP(String str) {
        e kQ;
        kQ = kQ(str);
        return kQ != null ? kQ.lastTime : 0L;
    }

    public synchronized void j(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aln = aln();
            ArrayList<e> arrayList = this.cFI.get(aln);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e kQ = kQ(str);
            boolean z = false;
            if (kQ != null) {
                if (kQ.lastTime != j) {
                    kQ.lastTime = j;
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
                d(aln, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject alx;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (alx = eVar.alx()) != null) {
                    jSONArray.put(alx);
                    arrayList2.add(eVar);
                }
            }
            if (!v.u(arrayList2)) {
                this.cFI.put(str, arrayList2);
                if (!this.cFH) {
                    alo();
                } else {
                    kR(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e kQ(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cFI.get(aln());
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

    private void kR(String str) {
        l<String> alp = alp();
        if (alp != null) {
            alp.f("frs_smart_sort_last_time", str);
        }
    }

    public void alo() {
        l<String> alp = alp();
        if (alp != null) {
            alp.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aZ */
                public void g(String str, String str2) {
                    if (str2 != null) {
                        ArrayList kS = a.this.kS(str2);
                        a.this.cFI.put(a.this.aln(), kS);
                    }
                    a.this.cFH = true;
                }
            });
        }
    }

    private l<String> alp() {
        return com.baidu.tbadk.core.c.a.te().O("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> kS(String str) {
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
