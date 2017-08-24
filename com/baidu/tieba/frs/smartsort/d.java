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

    public static d ajv() {
        if (cxB == null) {
            synchronized (d.class) {
                if (cxB == null) {
                    cxB = new d();
                }
            }
        }
        return cxB;
    }

    public String ajp() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void h(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String ajp = ajp();
            ArrayList<f> arrayList = this.cxA.get(ajp);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f kE = kE(str);
            boolean z = false;
            if (kE != null) {
                if (kE.cxD != i) {
                    kE.cxD = i;
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
                f(ajp, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject ajy;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (ajy = fVar.ajy()) != null) {
                    jSONArray.put(ajy);
                    arrayList2.add(fVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cxA.put(str, arrayList2);
                if (!this.cxu) {
                    ajw();
                } else {
                    kF(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f kE(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cxA.get(ajp());
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

    private void kF(String str) {
        l<String> ajr = ajr();
        if (ajr != null) {
            ajr.l("frs_sortType", str);
        }
    }

    public void ajw() {
        l<String> ajr = ajr();
        if (ajr != null) {
            ajr.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aV */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        d.this.cxA.put(d.this.ajp(), d.this.kD(str2));
                    }
                    d.this.cxu = true;
                }
            });
        }
    }

    private l<String> ajr() {
        return com.baidu.tbadk.core.c.a.to().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> kD(String str) {
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

    public void ajx() {
        kF("");
        this.cxA.remove(ajp());
    }
}
