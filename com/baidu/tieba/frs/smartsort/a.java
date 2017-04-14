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
    private static volatile a bYC;
    private boolean bYA = false;
    private final HashMap<String, ArrayList<g>> bYB = new HashMap<>();

    private a() {
    }

    public static a add() {
        if (bYC == null) {
            synchronized (a.class) {
                if (bYC == null) {
                    bYC = new a();
                }
            }
        }
        return bYC;
    }

    public String ade() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long iQ(String str) {
        g iR;
        iR = iR(str);
        return iR != null ? iR.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String ade = ade();
            ArrayList<g> arrayList = this.bYB.get(ade);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g iR = iR(str);
            boolean z = false;
            if (iR != null) {
                if (iR.lastTime != j) {
                    iR.lastTime = j;
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
                d(ade, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject ado;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (ado = gVar.ado()) != null) {
                    jSONArray.put(ado);
                    arrayList2.add(gVar);
                }
            }
            if (!x.q(arrayList2)) {
                this.bYB.put(str, arrayList2);
                if (!this.bYA) {
                    adf();
                } else {
                    iS(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g iR(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.bYB.get(ade());
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

    private void iS(String str) {
        o<String> adg = adg();
        if (adg != null) {
            adg.l("frs_smart_sort_last_time", str);
        }
    }

    public void adf() {
        o<String> adg = adg();
        if (adg != null) {
            adg.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> adg() {
        return com.baidu.tbadk.core.c.a.tM().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> iT(String str) {
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
