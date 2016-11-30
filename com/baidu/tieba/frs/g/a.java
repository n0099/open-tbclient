package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a cgS;
    private boolean cgQ = false;
    private final HashMap<String, ArrayList<h>> cgR = new HashMap<>();

    private a() {
    }

    public static a agJ() {
        if (cgS == null) {
            synchronized (a.class) {
                if (cgS == null) {
                    cgS = new a();
                }
            }
        }
        return cgS;
    }

    public String agK() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long kd(String str) {
        h ke;
        ke = ke(str);
        return ke != null ? ke.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String agK = agK();
            ArrayList<h> arrayList = this.cgR.get(agK);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h ke = ke(str);
            boolean z = false;
            if (ke != null) {
                if (ke.lastTime != j) {
                    ke.lastTime = j;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.lastTime = j;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                d(agK, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<h> arrayList) {
        JSONObject agU;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (!TextUtils.isEmpty(hVar.forumName) && (agU = hVar.agU()) != null) {
                    jSONArray.put(agU);
                    arrayList2.add(hVar);
                }
            }
            kf(jSONArray.toString());
            this.cgR.put(str, arrayList2);
        }
    }

    private synchronized h ke(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.cgR.get(agK());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        hVar = arrayList.get(i2);
                        if (str.equalsIgnoreCase(hVar.forumName)) {
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        hVar = null;
                        break;
                    }
                }
            } else {
                hVar = null;
            }
        } else {
            hVar = null;
        }
        return hVar;
    }

    private void kf(String str) {
        if (!this.cgQ) {
            agL();
            return;
        }
        o<String> agM = agM();
        if (agM != null) {
            agM.l("frs_smart_sort_last_time", str);
        }
    }

    public void agL() {
        o<String> agM = agM();
        if (agM != null) {
            agM.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> agM() {
        return com.baidu.tbadk.core.b.a.tm().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> kg(String str) {
        ArrayList<h> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new h(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
