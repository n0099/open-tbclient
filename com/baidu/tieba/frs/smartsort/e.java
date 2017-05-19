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
    private static volatile e bYO;
    private boolean bYF = false;
    private final HashMap<String, ArrayList<h>> bYN = new HashMap<>();

    private e() {
    }

    public static e aco() {
        if (bYO == null) {
            synchronized (e.class) {
                if (bYO == null) {
                    bYO = new e();
                }
            }
        }
        return bYO;
    }

    public String aci() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String aci = aci();
            ArrayList<h> arrayList = this.bYN.get(aci);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h jc = jc(str);
            boolean z = false;
            if (jc != null) {
                if (jc.bYQ != i) {
                    jc.bYQ = i;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.bYQ = i;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                f(aci, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<h> arrayList) {
        JSONObject acr;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.forumName) && (acr = hVar.acr()) != null) {
                    jSONArray.put(acr);
                    arrayList2.add(hVar);
                }
            }
            if (!x.r(arrayList2)) {
                this.bYN.put(str, arrayList2);
                if (!this.bYF) {
                    acp();
                } else {
                    jd(jSONArray.toString());
                }
            }
        }
    }

    public synchronized h jc(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.bYN.get(aci());
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

    private void jd(String str) {
        o<String> ack = ack();
        if (ack != null) {
            ack.l("frs_sortType", str);
        }
    }

    public void acp() {
        o<String> ack = ack();
        if (ack != null) {
            ack.a("frs_sortType", new f(this));
        }
    }

    private o<String> ack() {
        return com.baidu.tbadk.core.c.a.sZ().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> jb(String str) {
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

    public void acq() {
        jd("");
        this.bYN.remove(aci());
    }
}
