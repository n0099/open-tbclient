package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a bSP;
    private boolean bSN = false;
    private final HashMap<String, ArrayList<g>> bSO = new HashMap<>();

    private a() {
    }

    public static a acm() {
        if (bSP == null) {
            synchronized (a.class) {
                if (bSP == null) {
                    bSP = new a();
                }
            }
        }
        return bSP;
    }

    public String acn() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long iU(String str) {
        g iV;
        iV = iV(str);
        return iV != null ? iV.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String acn = acn();
            ArrayList<g> arrayList = this.bSO.get(acn);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g iV = iV(str);
            boolean z = false;
            if (iV != null) {
                if (iV.lastTime != j) {
                    iV.lastTime = j;
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
                d(acn, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject acw;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (acw = gVar.acw()) != null) {
                    jSONArray.put(acw);
                    arrayList2.add(gVar);
                }
            }
            if (!w.s(arrayList2)) {
                this.bSO.put(str, arrayList2);
                if (!this.bSN) {
                    aco();
                } else {
                    iW(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g iV(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.bSO.get(acn());
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

    private void iW(String str) {
        o<String> acp = acp();
        if (acp != null) {
            acp.l("frs_smart_sort_last_time", str);
        }
    }

    public void aco() {
        o<String> acp = acp();
        if (acp != null) {
            acp.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> acp() {
        return com.baidu.tbadk.core.c.a.sR().N("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> iX(String str) {
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
