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
public class e {
    private static volatile e bYJ;
    private boolean bYA = false;
    private final HashMap<String, ArrayList<h>> bYI = new HashMap<>();

    private e() {
    }

    public static e adl() {
        if (bYJ == null) {
            synchronized (e.class) {
                if (bYJ == null) {
                    bYJ = new e();
                }
            }
        }
        return bYJ;
    }

    public String ade() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String ade = ade();
            ArrayList<h> arrayList = this.bYI.get(ade);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h iU = iU(str);
            boolean z = false;
            if (iU != null) {
                if (iU.bYL != i) {
                    iU.bYL = i;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.bYL = i;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                f(ade, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<h> arrayList) {
        JSONObject ado;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.forumName) && (ado = hVar.ado()) != null) {
                    jSONArray.put(ado);
                    arrayList2.add(hVar);
                }
            }
            if (!x.q(arrayList2)) {
                this.bYI.put(str, arrayList2);
                if (!this.bYA) {
                    adm();
                } else {
                    iV(jSONArray.toString());
                }
            }
        }
    }

    public synchronized h iU(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.bYI.get(ade());
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

    private void iV(String str) {
        o<String> adg = adg();
        if (adg != null) {
            adg.l("frs_sortType", str);
        }
    }

    public void adm() {
        o<String> adg = adg();
        if (adg != null) {
            adg.a("frs_sortType", new f(this));
        }
    }

    private o<String> adg() {
        return com.baidu.tbadk.core.c.a.tM().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> iT(String str) {
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

    public void adn() {
        iV("");
        this.bYI.remove(ade());
    }
}
