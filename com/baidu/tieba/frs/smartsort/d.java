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
/* loaded from: classes2.dex */
public class d {
    private static volatile d dTZ;
    private boolean dTS = false;
    private final HashMap<String, ArrayList<f>> dTY = new HashMap<>();

    private d() {
    }

    public static d azM() {
        if (dTZ == null) {
            synchronized (d.class) {
                if (dTZ == null) {
                    dTZ = new d();
                }
            }
        }
        return dTZ;
    }

    public String azH() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void h(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String azH = azH();
            ArrayList<f> arrayList = this.dTY.get(azH);
            ArrayList<f> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            f mo = mo(str);
            boolean z = false;
            if (mo != null) {
                if (mo.dUd != i) {
                    mo.dUd = i;
                    z = true;
                }
            } else {
                f fVar = new f();
                fVar.forumName = str;
                fVar.dUd = i;
                arrayList2.add(fVar);
                z = true;
            }
            if (z) {
                f(azH, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<f> arrayList) {
        JSONObject azQ;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<f> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                f fVar = arrayList.get(i);
                if (fVar != null && !TextUtils.isEmpty(fVar.forumName) && (azQ = fVar.azQ()) != null) {
                    jSONArray.put(azQ);
                    arrayList2.add(fVar);
                }
            }
            if (!v.E(arrayList2)) {
                this.dTY.put(str, arrayList2);
                if (!this.dTS) {
                    azN();
                } else {
                    mp(jSONArray.toString());
                }
            }
        }
    }

    public synchronized f mo(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<f> arrayList = this.dTY.get(azH());
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

    private void mp(String str) {
        l<String> azJ = azJ();
        if (azJ != null) {
            azJ.f("frs_sortType", str);
        }
    }

    public void azN() {
        com.baidu.tbadk.util.v.a(new u<l<String>>() { // from class: com.baidu.tieba.frs.smartsort.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: azP */
            public l<String> doInBackground() {
                return d.this.azJ();
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
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (str2 != null) {
                                d.this.dTY.put(d.this.azH(), d.this.mn(str2));
                            }
                            d.this.dTS = true;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l<String> azJ() {
        return com.baidu.tbadk.core.c.a.AQ().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> mn(String str) {
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

    public void azO() {
        mp("");
        this.dTY.remove(azH());
    }
}
