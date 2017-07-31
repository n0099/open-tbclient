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
    private static volatile d cvy;
    private boolean cvr = false;
    private final HashMap<String, ArrayList<f>> cvx = new HashMap<>();

    private d() {
    }

    public static d aiU() {
        if (cvy == null) {
            synchronized (d.class) {
                if (cvy == null) {
                    cvy = new d();
                }
            }
        }
        return cvy;
    }

    public String aiO() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void g(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String aiO = aiO();
            ArrayList<f> arrayList = this.cvx.get(aiO);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f kx = kx(str);
            boolean z = false;
            if (kx != null) {
                if (kx.cvA != i) {
                    kx.cvA = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cvA = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(aiO, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject aiX;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (aiX = fVar.aiX()) != null) {
                    jSONArray.put(aiX);
                    arrayList2.add(fVar);
                }
            }
            if (!u.v(arrayList2)) {
                this.cvx.put(str, arrayList2);
                if (!this.cvr) {
                    aiV();
                } else {
                    ky(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f kx(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cvx.get(aiO());
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

    private void ky(String str) {
        l<String> aiQ = aiQ();
        if (aiQ != null) {
            aiQ.l("frs_sortType", str);
        }
    }

    public void aiV() {
        l<String> aiQ = aiQ();
        if (aiQ != null) {
            aiQ.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.cache.l.a
                /* renamed from: aT */
                public void m(String str, String str2) {
                    if (str2 != null) {
                        d.this.cvx.put(d.this.aiO(), d.this.kw(str2));
                    }
                    d.this.cvr = true;
                }
            });
        }
    }

    private l<String> aiQ() {
        return com.baidu.tbadk.core.c.a.tn().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> kw(String str) {
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

    public void aiW() {
        ky("");
        this.cvx.remove(aiO());
    }
}
