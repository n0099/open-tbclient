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
    private static volatile a caT;
    private boolean caR = false;
    private final HashMap<String, ArrayList<g>> caS = new HashMap<>();

    private a() {
    }

    public static a aee() {
        if (caT == null) {
            synchronized (a.class) {
                if (caT == null) {
                    caT = new a();
                }
            }
        }
        return caT;
    }

    public String aef() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long iR(String str) {
        g iS;
        iS = iS(str);
        return iS != null ? iS.lastTime : 0L;
    }

    public synchronized void i(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String aef = aef();
            ArrayList<g> arrayList = this.caS.get(aef);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g iS = iS(str);
            boolean z = false;
            if (iS != null) {
                if (iS.lastTime != j) {
                    iS.lastTime = j;
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
                d(aef, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject aep;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (aep = gVar.aep()) != null) {
                    jSONArray.put(aep);
                    arrayList2.add(gVar);
                }
            }
            if (!x.q(arrayList2)) {
                this.caS.put(str, arrayList2);
                if (!this.caR) {
                    aeg();
                } else {
                    iT(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g iS(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.caS.get(aef());
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

    private void iT(String str) {
        o<String> aeh = aeh();
        if (aeh != null) {
            aeh.l("frs_smart_sort_last_time", str);
        }
    }

    public void aeg() {
        o<String> aeh = aeh();
        if (aeh != null) {
            aeh.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> aeh() {
        return com.baidu.tbadk.core.c.a.tM().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> iU(String str) {
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
