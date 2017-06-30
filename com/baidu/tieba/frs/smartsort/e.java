package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static volatile e cno;
    private boolean cng = false;
    private final HashMap<String, ArrayList<h>> cnn = new HashMap<>();

    private e() {
    }

    public static e ahk() {
        if (cno == null) {
            synchronized (e.class) {
                if (cno == null) {
                    cno = new e();
                }
            }
        }
        return cno;
    }

    public String ahe() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String ahe = ahe();
            ArrayList<h> arrayList = this.cnn.get(ahe);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h kh = kh(str);
            boolean z = false;
            if (kh != null) {
                if (kh.cnq != i) {
                    kh.cnq = i;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.cnq = i;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                f(ahe, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<h> arrayList) {
        JSONObject ahn;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.forumName) && (ahn = hVar.ahn()) != null) {
                    jSONArray.put(ahn);
                    arrayList2.add(hVar);
                }
            }
            if (!z.t(arrayList2)) {
                this.cnn.put(str, arrayList2);
                if (!this.cng) {
                    ahl();
                } else {
                    ki(jSONArray.toString());
                }
            }
        }
    }

    public synchronized h kh(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.cnn.get(ahe());
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

    private void ki(String str) {
        o<String> ahg = ahg();
        if (ahg != null) {
            ahg.l("frs_sortType", str);
        }
    }

    public void ahl() {
        o<String> ahg = ahg();
        if (ahg != null) {
            ahg.a("frs_sortType", new f(this));
        }
    }

    private o<String> ahg() {
        return com.baidu.tbadk.core.c.a.sW().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> kg(String str) {
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

    public void ahm() {
        ki("");
        this.cnn.remove(ahe());
    }
}
