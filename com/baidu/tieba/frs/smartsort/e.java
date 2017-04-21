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
    private static volatile e cba;
    private boolean caR = false;
    private final HashMap<String, ArrayList<h>> caZ = new HashMap<>();

    private e() {
    }

    public static e aem() {
        if (cba == null) {
            synchronized (e.class) {
                if (cba == null) {
                    cba = new e();
                }
            }
        }
        return cba;
    }

    public String aef() {
        return "frs_sorttype_" + TbadkCoreApplication.getCurrentAccount();
    }

    public synchronized void f(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String aef = aef();
            ArrayList<h> arrayList = this.caZ.get(aef);
            ArrayList<h> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            h iV = iV(str);
            boolean z = false;
            if (iV != null) {
                if (iV.cbc != i) {
                    iV.cbc = i;
                    z = true;
                }
            } else {
                h hVar = new h();
                hVar.forumName = str;
                hVar.cbc = i;
                arrayList2.add(hVar);
                z = true;
            }
            if (z) {
                f(aef, arrayList2);
            }
        }
    }

    private synchronized void f(String str, ArrayList<h> arrayList) {
        JSONObject aep;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            int min = Math.min(30, arrayList.size());
            int size = arrayList.size() > 30 ? arrayList.size() - 30 : 0;
            ArrayList<h> arrayList2 = new ArrayList<>();
            for (int i = size; i < min; i++) {
                h hVar = arrayList.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.forumName) && (aep = hVar.aep()) != null) {
                    jSONArray.put(aep);
                    arrayList2.add(hVar);
                }
            }
            if (!x.q(arrayList2)) {
                this.caZ.put(str, arrayList2);
                if (!this.caR) {
                    aen();
                } else {
                    iW(jSONArray.toString());
                }
            }
        }
    }

    public synchronized h iV(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<h> arrayList = this.caZ.get(aef());
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

    private void iW(String str) {
        o<String> aeh = aeh();
        if (aeh != null) {
            aeh.l("frs_sortType", str);
        }
    }

    public void aen() {
        o<String> aeh = aeh();
        if (aeh != null) {
            aeh.a("frs_sortType", new f(this));
        }
    }

    private o<String> aeh() {
        return com.baidu.tbadk.core.c.a.tM().M("frs_sortType", TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> iU(String str) {
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

    public void aeo() {
        iW("");
        this.caZ.remove(aef());
    }
}
