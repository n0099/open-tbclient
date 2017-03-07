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
    private static volatile e cai;
    private boolean bZZ = false;
    private final HashMap<String, ArrayList<h>> cah = new HashMap<>();

    private e() {
    }

    public static e adr() {
        if (cai == null) {
            synchronized (e.class) {
                if (cai == null) {
                    cai = new e();
                }
            }
        }
        return cai;
    }

    public String adk() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i != 4) {
            String adk = adk();
            ArrayList<h> arrayList = this.cah.get(adk);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h iP = iP(str);
            boolean z = false;
            if (iP != null) {
                if (iP.cak != i) {
                    iP.cak = i;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.cak = i;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                f(adk, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<h> arrayList) {
        JSONObject adu;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.forumName) && (adu = hVar.adu()) != null) {
                    jSONArray.put(adu);
                    arrayList2.add(hVar);
                }
            }
            if (!x.q(arrayList2)) {
                this.cah.put(str, arrayList2);
                if (!this.bZZ) {
                    ads();
                } else {
                    iQ(jSONArray.toString());
                }
            }
        }
    }

    public synchronized h iP(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.cah.get(adk());
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

    private void iQ(String str) {
        o<String> adm = adm();
        if (adm != null) {
            adm.l("frs_sortType", str);
        }
    }

    public void ads() {
        o<String> adm = adm();
        if (adm != null) {
            adm.a("frs_sortType", new f(this));
        }
    }

    private o<String> adm() {
        return com.baidu.tbadk.core.c.a.to().L("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> iO(String str) {
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

    public void adt() {
        iQ("");
        this.cah.remove(adk());
    }
}
