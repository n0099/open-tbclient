package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a cab;
    private boolean bZZ = false;
    private final HashMap<String, ArrayList<g>> caa = new HashMap<>();

    private a() {
    }

    public static a adj() {
        if (cab == null) {
            synchronized (a.class) {
                if (cab == null) {
                    cab = new a();
                }
            }
        }
        return cab;
    }

    public String adk() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long iL(String str) {
        g iM;
        iM = iM(str);
        return iM != null ? iM.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String adk = adk();
            ArrayList<g> arrayList = this.caa.get(adk);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g iM = iM(str);
            boolean z = false;
            if (iM != null) {
                if (iM.lastTime != j) {
                    iM.lastTime = j;
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
                d(adk, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject adu;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (adu = gVar.adu()) != null) {
                    jSONArray.put(adu);
                    arrayList2.add(gVar);
                }
            }
            if (!x.q(arrayList2)) {
                this.caa.put(str, arrayList2);
                if (!this.bZZ) {
                    adl();
                } else {
                    iN(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g iM(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.caa.get(adk());
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

    private void iN(String str) {
        o<String> adm = adm();
        if (adm != null) {
            adm.l("frs_smart_sort_last_time", str);
        }
    }

    public void adl() {
        o<String> adm = adm();
        if (adm != null) {
            adm.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> adm() {
        return com.baidu.tbadk.core.c.a.to().L("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> iO(String str) {
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
