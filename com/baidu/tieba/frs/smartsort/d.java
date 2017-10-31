package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static volatile d cOP;
    private boolean cOI = false;
    private final HashMap<String, ArrayList<f>> cOO = new HashMap<>();

    private d() {
    }

    public static d anZ() {
        if (cOP == null) {
            synchronized (d.class) {
                if (cOP == null) {
                    cOP = new d();
                }
            }
        }
        return cOP;
    }

    public String anT() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void h(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String anT = anT();
            ArrayList<f> arrayList = this.cOO.get(anT);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f lt = lt(str);
            boolean z = false;
            if (lt != null) {
                if (lt.cOS != i) {
                    lt.cOS = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.cOS = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(anT, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject aod;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (aod = fVar.aod()) != null) {
                    jSONArray.put(aod);
                    arrayList2.add(fVar);
                }
            }
            if (!v.v(arrayList2)) {
                this.cOO.put(str, arrayList2);
                if (!this.cOI) {
                    aoa();
                } else {
                    lu(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f lt(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.cOO.get(anT());
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

    private void lu(String str) {
        l<String> anV = anV();
        if (anV != null) {
            anV.f("frs_sortType", str);
        }
    }

    public void aoa() {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aoc */
            public l<String> doInBackground() {
                return d.this.anV();
            }
        }, new h<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: e */
            public void onReturnDataInUI(l<String> lVar) {
                if (lVar != null) {
                    lVar.a("frs_sortType", new l.a<String>() { // from class: com.baidu.tieba.frs.smartsort.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aT */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.cOO.put(d.this.anT(), d.this.ls(str2));
                            }
                            d.this.cOI = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> anV() {
        return com.baidu.tbadk.core.c.a.td().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> ls(String str) {
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

    public void aob() {
        lu("");
        this.cOO.remove(anT());
    }
}
