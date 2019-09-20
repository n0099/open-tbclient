package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cWY;
    private ArrayList<Integer> cWU = new ArrayList<>();
    private c cWV;
    private a cWZ;
    private List<an> cXa;

    public static d aCV() {
        if (cWY == null) {
            synchronized (c.class) {
                if (cWY == null) {
                    cWY = new d();
                }
            }
        }
        return cWY;
    }

    private d() {
        this.cWU.add(1);
        this.cWU.add(2);
        this.cWV = new c();
        this.cWZ = new a(this.cWV, this.cWU);
        my(com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_abtest_channel", 0));
    }

    public int ag(String str, int i) {
        if (this.cWZ == null) {
            return 0;
        }
        return this.cWZ.ag(str, i);
    }

    public void sx(String str) {
        if (this.cWZ != null) {
            this.cWZ.sw(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.cXa == null) {
                this.cXa = new ArrayList();
            }
            this.cXa.add(anVar);
        }
    }

    public void bJ(String str, String str2) {
        if (!v.aa(this.cXa) && this.cWV != null && this.cWV.aCT()) {
            int i = -1;
            for (an anVar : this.cXa) {
                if (anVar != null) {
                    if (anVar.getPosition() == 0) {
                        a(str, str2, anVar);
                    } else if (i != anVar.getPosition()) {
                        i = anVar.getPosition();
                        a(str, str2, anVar);
                    }
                    i = i;
                }
            }
            this.cXa.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.cWV != null && this.cWV.aCT()) {
            HashMap hashMap = new HashMap();
            List<Object> params = anVar.getParams();
            if (params != null) {
                int size = params.size();
                for (int i = 0; i < size; i += 2) {
                    String str3 = "";
                    Object obj = params.get(i);
                    if (obj != null) {
                        str3 = obj.toString();
                    }
                    String str4 = "";
                    Object obj2 = params.get(i + 1);
                    if (obj2 != null) {
                        str4 = obj2.toString();
                    }
                    hashMap.put(str3, str4);
                }
            }
            com.baidu.ubs.analytics.a.a(str2 + anVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (aq.isEmpty(str) || this.cWV == null || !this.cWV.aCT()) {
            com.baidu.ubs.analytics.a.HE(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.cWV == null || !this.cWV.aCT()) {
            com.baidu.ubs.analytics.a.HF(str);
        }
    }

    public void my(int i) {
        if (this.cWV != null) {
            this.cWV.my(i);
        }
    }
}
