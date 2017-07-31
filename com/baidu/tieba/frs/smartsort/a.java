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
    private static volatile a cvt;
    private boolean cvr = false;
    private final HashMap<String, ArrayList<e>> cvs = new HashMap<>();

    private a() {
    }

    public static a aiN() {
        if (cvt == null) {
            synchronized (a.class) {
                if (cvt == null) {
                    cvt = new a();
                }
            }
        }
        return cvt;
    }

    public String aiO() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kt(String str) {
        e ku;
        ku = ku(str);
        return ku != null ? ku.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aiO = aiO();
            ArrayList<e> arrayList = this.cvs.get(aiO);
            ArrayList<e> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            e ku = ku(str);
            boolean z = false;
            if (ku != null) {
                if (ku.lastTime != j) {
                    ku.lastTime = j;
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
                d(aiO, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<e> arrayList) {
        JSONObject aiX;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                e eVar = arrayList.get(i);
                if (!TextUtils.isEmpty(eVar.forumName) && (aiX = eVar.aiX()) != null) {
                    jSONArray.put(aiX);
                    arrayList2.add(eVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cvs.put(str, arrayList2);
                if (!this.cvr) {
                    aiP();
                } else {
                    kv(jSONArray.toString());
                }
            }
        }
    }

    private synchronized e ku(String str) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<e> arrayList = this.cvs.get(aiO());
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

    private void kv(String str) {
        l<String> aiQ = aiQ();
        if (aiQ != null) {
            aiQ.l("frs_smart_sort_last_time", str);
        }
    }

    public void aiP() {
        l<String> aiQ = aiQ();
        if (aiQ != null) {
            aiQ.a("frs_smart_sort_last_time", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aT */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        ArrayList kw = a.this.kw(str2);
                        a.this.cvs.put(a.this.aiO(), kw);
                    }
                    a.this.cvr = true;
                }
            });
        }
    }

    private l<String> aiQ() {
        return com.baidu.tbadk.core.c.a.tn().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e> kw(String str) {
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
