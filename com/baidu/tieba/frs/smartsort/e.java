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
    private static volatile e ceZ;
    private boolean ceR = false;
    private final HashMap<String, ArrayList<h>> ceY = new HashMap<>();

    private e() {
    }

    public static e ads() {
        if (ceZ == null) {
            synchronized (e.class) {
                if (ceZ == null) {
                    ceZ = new e();
                }
            }
        }
        return ceZ;
    }

    public String adm() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String adm = adm();
            ArrayList<h> arrayList = this.ceY.get(adm);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h jk = jk(str);
            boolean z = false;
            if (jk != null) {
                if (jk.cfb != i) {
                    jk.cfb = i;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.cfb = i;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                f(adm, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<h> arrayList) {
        JSONObject adv;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.forumName) && (adv = hVar.adv()) != null) {
                    jSONArray.put(adv);
                    arrayList2.add(hVar);
                }
            }
            if (!x.r(arrayList2)) {
                this.ceY.put(str, arrayList2);
                if (!this.ceR) {
                    adt();
                } else {
                    jl(jSONArray.toString());
                }
            }
        }
    }

    public synchronized h jk(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.ceY.get(adm());
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

    private void jl(String str) {
        o<String> ado = ado();
        if (ado != null) {
            ado.l("frs_sortType", str);
        }
    }

    public void adt() {
        o<String> ado = ado();
        if (ado != null) {
            ado.a("frs_sortType", new f(this));
        }
    }

    private o<String> ado() {
        return com.baidu.tbadk.core.c.a.sY().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> jj(String str) {
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

    public void adu() {
        jl("");
        this.ceY.remove(adm());
    }
}
