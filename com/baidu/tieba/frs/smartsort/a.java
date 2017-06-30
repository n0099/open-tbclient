package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a cni;
    private boolean cng = false;
    private final HashMap<String, ArrayList<g>> cnh = new HashMap<>();

    private a() {
    }

    public static a ahd() {
        if (cni == null) {
            synchronized (a.class) {
                if (cni == null) {
                    cni = new a();
                }
            }
        }
        return cni;
    }

    public String ahe() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kd(String str) {
        g ke;
        ke = ke(str);
        return ke != null ? ke.lastTime : 0L;
    }

    public synchronized void h(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ahe = ahe();
            ArrayList<g> arrayList = this.cnh.get(ahe);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g ke = ke(str);
            boolean z = false;
            if (ke != null) {
                if (ke.lastTime != j) {
                    ke.lastTime = j;
                    z = true;
                }
            } else {
                g gVar = new g();
                gVar.forumName = str;
                gVar.lastTime = j;
                arrayList2.add(gVar);
                z = true;
            }
            if (z) {
                d(ahe, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject ahn;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (ahn = gVar.ahn()) != null) {
                    jSONArray.put(ahn);
                    arrayList2.add(gVar);
                }
            }
            if (!z.t(arrayList2)) {
                this.cnh.put(str, arrayList2);
                if (!this.cng) {
                    ahf();
                } else {
                    kf(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g ke(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.cnh.get(ahe());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        gVar = arrayList.get(i2);
                        if (str.equalsIgnoreCase(gVar.forumName)) {
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        gVar = null;
                        break;
                    }
                }
            } else {
                gVar = null;
            }
        } else {
            gVar = null;
        }
        return gVar;
    }

    private void kf(String str) {
        o<String> ahg = ahg();
        if (ahg != null) {
            ahg.l("frs_smart_sort_last_time", str);
        }
    }

    public void ahf() {
        o<String> ahg = ahg();
        if (ahg != null) {
            ahg.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> ahg() {
        return com.baidu.tbadk.core.c.a.sW().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> kg(String str) {
        ArrayList<g> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new g(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
