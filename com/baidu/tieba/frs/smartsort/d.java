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
    private static volatile d cxB;
    private boolean cxu = false;
    private final HashMap<String, ArrayList<f>> cxA = new HashMap<>();

    private d() {
    }

    public static d ajB() {
        if (cxB == null) {
            synchronized (d.class) {
                if (cxB == null) {
                    cxB = new d();
                }
            }
        }
        return cxB;
    }

    public String ajv() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void g(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String ajv = ajv();
            ArrayList<f> arrayList = this.cxA.get(ajv);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f kB = kB(str);
            boolean z = false;
            if (kB != null) {
                if (kB.cxD != i) {
                    kB.cxD = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cxD = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(ajv, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject ajE;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (ajE = fVar.ajE()) != null) {
                    jSONArray.put(ajE);
                    arrayList2.add(fVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cxA.put(str, arrayList2);
                if (!this.cxu) {
                    ajC();
                } else {
                    kC(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f kB(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cxA.get(ajv());
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

    private void kC(String str) {
        l<String> ajx = ajx();
        if (ajx != null) {
            ajx.l("frs_sortType", str);
        }
    }

    public void ajC() {
        l<String> ajx = ajx();
        if (ajx != null) {
            ajx.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aU */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        d.this.cxA.put(d.this.ajv(), d.this.kA(str2));
                    }
                    d.this.cxu = true;
                }
            });
        }
    }

    private l<String> ajx() {
        return com.baidu.tbadk.core.c.a.tn().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> kA(String str) {
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

    public void ajD() {
        kC("");
        this.cxA.remove(ajv());
    }
}
