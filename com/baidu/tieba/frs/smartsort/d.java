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
public class d {
    private static volatile d cug;
    private boolean ctZ = false;
    private final HashMap<String, ArrayList<f>> cuf = new HashMap<>();

    private d() {
    }

    public static d aiI() {
        if (cug == null) {
            synchronized (d.class) {
                if (cug == null) {
                    cug = new d();
                }
            }
        }
        return cug;
    }

    public String aiC() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void g(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String aiC = aiC();
            ArrayList<f> arrayList = this.cuf.get(aiC);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f kt = kt(str);
            boolean z = false;
            if (kt != null) {
                if (kt.cui != i) {
                    kt.cui = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cui = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(aiC, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject aiL;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (aiL = fVar.aiL()) != null) {
                    jSONArray.put(aiL);
                    arrayList2.add(fVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cuf.put(str, arrayList2);
                if (!this.ctZ) {
                    aiJ();
                } else {
                    ku(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f kt(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cuf.get(aiC());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        fVar = null;
                        break;
                    }
                    fVar = arrayList.get(i2);
                    if (str.equalsIgnoreCase(fVar.forumName)) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                fVar = null;
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    private void ku(String str) {
        l<String> aiE = aiE();
        if (aiE != null) {
            aiE.l("frs_sortType", str);
        }
    }

    public void aiJ() {
        l<String> aiE = aiE();
        if (aiE != null) {
            aiE.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aT */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        d.this.cuf.put(d.this.aiC(), d.this.ks(str2));
                    }
                    d.this.ctZ = true;
                }
            });
        }
    }

    private l<String> aiE() {
        return com.baidu.tbadk.core.c.a.td().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> ks(String str) {
        ArrayList<f> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new f(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void aiK() {
        ku("");
        this.cuf.remove(aiC());
    }
}
