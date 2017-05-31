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
    private static volatile a ceT;
    private boolean ceR = false;
    private final HashMap<String, ArrayList<g>> ceS = new HashMap<>();

    private a() {
    }

    public static a adl() {
        if (ceT == null) {
            synchronized (a.class) {
                if (ceT == null) {
                    ceT = new a();
                }
            }
        }
        return ceT;
    }

    public String adm() {
        return "frs_smart_sort_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized long jg(String str) {
        g jh;
        jh = jh(str);
        return jh != null ? jh.lastTime : 0L;
    }

    public synchronized void h(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            String adm = adm();
            ArrayList<g> arrayList = this.ceS.get(adm);
            ArrayList<g> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            g jh = jh(str);
            boolean z = false;
            if (jh != null) {
                if (jh.lastTime != j) {
                    jh.lastTime = j;
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
                d(adm, arrayList2);
            }
        }
    }

    private synchronized void d(String str, ArrayList<g> arrayList) {
        JSONObject adv;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<g> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.forumName) && (adv = gVar.adv()) != null) {
                    jSONArray.put(adv);
                    arrayList2.add(gVar);
                }
            }
            if (!x.r(arrayList2)) {
                this.ceS.put(str, arrayList2);
                if (!this.ceR) {
                    adn();
                } else {
                    ji(jSONArray.toString());
                }
            }
        }
    }

    private synchronized g jh(String str) {
        g gVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<g> arrayList = this.ceS.get(adm());
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

    private void ji(String str) {
        o<String> ado = ado();
        if (ado != null) {
            ado.l("frs_smart_sort_last_time", str);
        }
    }

    public void adn() {
        o<String> ado = ado();
        if (ado != null) {
            ado.a("frs_smart_sort_last_time", new b(this));
        }
    }

    private o<String> ado() {
        return com.baidu.tbadk.core.c.a.sY().M("frs_smart_sort_last_time", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> jj(String str) {
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
