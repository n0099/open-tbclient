package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static volatile f cgZ;
    private boolean cgQ = false;
    private final HashMap<String, ArrayList<i>> cgY = new HashMap<>();

    private f() {
    }

    public static f agR() {
        if (cgZ == null) {
            synchronized (f.class) {
                if (cgZ == null) {
                    cgZ = new f();
                }
            }
        }
        return cgZ;
    }

    public String agK() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i != 4) {
            String agK = agK();
            ArrayList<i> arrayList = this.cgY.get(agK);
            ArrayList<i> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            i kh = kh(str);
            boolean z = false;
            if (kh != null) {
                if (kh.chb != i) {
                    kh.chb = i;
                    z = true;
                }
            } else {
                i iVar = new i();
                iVar.forumName = str;
                iVar.chb = i;
                arrayList2.add(iVar);
                z = true;
            }
            if (z) {
                f(agK, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<i> arrayList) {
        JSONObject agU;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<i> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                i iVar = arrayList.get(i);
                if (!TextUtils.isEmpty(iVar.forumName) && (agU = iVar.agU()) != null) {
                    jSONArray.put(agU);
                    arrayList2.add(iVar);
                }
            }
            ki(jSONArray.toString());
            this.cgY.put(str, arrayList2);
        }
    }

    public synchronized i kh(String str) {
        i iVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<i> arrayList = this.cgY.get(agK());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        iVar = arrayList.get(i2);
                        if (str.equalsIgnoreCase(iVar.forumName)) {
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        iVar = null;
                        break;
                    }
                }
            } else {
                iVar = null;
            }
        } else {
            iVar = null;
        }
        return iVar;
    }

    private void ki(String str) {
        if (!this.cgQ) {
            agS();
            return;
        }
        o<String> agM = agM();
        if (agM != null) {
            agM.l("frs_sortType", str);
        }
    }

    public void agS() {
        o<String> agM = agM();
        if (agM != null) {
            agM.a("frs_sortType", new g(this));
        }
    }

    private o<String> agM() {
        return com.baidu.tbadk.core.b.a.tm().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<i> kg(String str) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new i(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void agT() {
        ki("");
        this.cgY.remove(agK());
    }
}
