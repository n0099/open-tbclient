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
    private static volatile a bYH;
    private boolean bYF = false;
    private final HashMap<String, ArrayList<g>> bYG = new HashMap<>();

    private a() {
    }

    public static a ach() {
        if (bYH == null) {
            synchronized (a.class) {
                if (bYH == null) {
                    bYH = new a();
                }
            }
        }
        return bYH;
    }

    public String aci() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long iY(String str) {
        g iZ;
        iZ = iZ(str);
        return iZ != null ? iZ.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aci = aci();
            ArrayList<g> arrayList = this.bYG.get(aci);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g iZ = iZ(str);
            boolean z = false;
            if (iZ != null) {
                if (iZ.lastTime != j) {
                    iZ.lastTime = j;
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
                d(aci, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject acr;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (acr = gVar.acr()) != null) {
                    jSONArray.put(acr);
                    arrayList2.add(gVar);
                }
            }
            if (!x.r(arrayList2)) {
                this.bYG.put(str, arrayList2);
                if (!this.bYF) {
                    acj();
                } else {
                    ja(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g iZ(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.bYG.get(aci());
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

    private void ja(String str) {
        o<String> ack = ack();
        if (ack != null) {
            ack.l("frs_smart_sort_last_time", str);
        }
    }

    public void acj() {
        o<String> ack = ack();
        if (ack != null) {
            ack.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> ack() {
        return com.baidu.tbadk.core.c.a.sZ().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> jb(String str) {
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
