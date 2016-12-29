package com.baidu.tieba.frs.f;

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
    private static volatile a bMB;
    private boolean bMz = false;
    private final HashMap<String, ArrayList<h>> bMA = new HashMap<>();

    private a() {
    }

    public static a abf() {
        if (bMB == null) {
            synchronized (a.class) {
                if (bMB == null) {
                    bMB = new a();
                }
            }
        }
        return bMB;
    }

    public String abg() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long iH(String str) {
        h iI;
        iI = iI(str);
        return iI != null ? iI.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String abg = abg();
            ArrayList<h> arrayList = this.bMA.get(abg);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h iI = iI(str);
            boolean z = false;
            if (iI != null) {
                if (iI.lastTime != j) {
                    iI.lastTime = j;
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
                d(abg, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<h> arrayList) {
        JSONObject abp;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (!TextUtils.isEmpty(hVar.forumName) && (abp = hVar.abp()) != null) {
                    jSONArray.put(abp);
                    arrayList2.add(hVar);
                }
            }
            if (!x.t(arrayList2)) {
                this.bMA.put(str, arrayList2);
                if (!this.bMz) {
                    abh();
                } else {
                    iJ(jSONArray.toString());
                }
            }
        }
    }

    private synchronized h iI(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.bMA.get(abg());
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

    private void iJ(String str) {
        o<String> abi = abi();
        if (abi != null) {
            abi.l("frs_smart_sort_last_time", str);
        }
    }

    public void abh() {
        o<String> abi = abi();
        if (abi != null) {
            abi.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> abi() {
        return com.baidu.tbadk.core.b.a.sX().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> iK(String str) {
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
