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
public class f {
    private static volatile f bMI;
    private boolean bMz = false;
    private final HashMap<String, ArrayList<i>> bMH = new HashMap<>();

    private f() {
    }

    public static f abm() {
        if (bMI == null) {
            synchronized (f.class) {
                if (bMI == null) {
                    bMI = new f();
                }
            }
        }
        return bMI;
    }

    public String abg() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i != 4) {
            String abg = abg();
            ArrayList<i> arrayList = this.bMH.get(abg);
            ArrayList<i> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            i iL = iL(str);
            boolean z = false;
            if (iL != null) {
                if (iL.bMK != i) {
                    iL.bMK = i;
                    z = true;
                }
            } else {
                i iVar = new i();
                iVar.forumName = str;
                iVar.bMK = i;
                arrayList2.add(iVar);
                z = true;
            }
            if (z) {
                f(abg, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<i> arrayList) {
        JSONObject abp;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<i> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                i iVar = arrayList.get(i);
                if (iVar != null && !TextUtils.isEmpty(iVar.forumName) && (abp = iVar.abp()) != null) {
                    jSONArray.put(abp);
                    arrayList2.add(iVar);
                }
            }
            if (!x.t(arrayList2)) {
                this.bMH.put(str, arrayList2);
                if (!this.bMz) {
                    abn();
                } else {
                    iM(jSONArray.toString());
                }
            }
        }
    }

    public synchronized i iL(String str) {
        i iVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<i> arrayList = this.bMH.get(abg());
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        iVar = arrayList.get(i2);
                        if (str.equalsIgnoreCase(iVar.forumName)) {
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        iVar = null;
                        break;
                    }
                }
            } else {
                iVar = null;
            }
        } else {
            iVar = null;
        }
        return iVar;
    }

    private void iM(String str) {
        o<String> abi = abi();
        if (abi != null) {
            abi.l("frs_sortType", str);
        }
    }

    public void abn() {
        o<String> abi = abi();
        if (abi != null) {
            abi.a("frs_sortType", new g(this));
        }
    }

    private o<String> abi() {
        return com.baidu.tbadk.core.b.a.sX().N("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<i> iK(String str) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new i(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void abo() {
        iM("");
        this.bMH.remove(abg());
    }
}
