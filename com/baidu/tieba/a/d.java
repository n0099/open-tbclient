package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cVY;
    private ArrayList<Integer> cVU = new ArrayList<>();
    private c cVV;
    private a cVZ;
    private List<an> cWa;

    public static d aCF() {
        if (cVY == null) {
            synchronized (c.class) {
                if (cVY == null) {
                    cVY = new d();
                }
            }
        }
        return cVY;
    }

    private d() {
        this.cVU.add(1);
        this.cVU.add(2);
        this.cVV = new c();
        this.cVZ = new a(this.cVV, this.cVU);
        mt(com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_abtest_channel", 0));
    }

    public int ag(String str, int i) {
        if (this.cVZ == null) {
            return 0;
        }
        return this.cVZ.ag(str, i);
    }

    public void sl(String str) {
        if (this.cVZ != null) {
            this.cVZ.sk(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.cWa == null) {
                this.cWa = new ArrayList();
            }
            this.cWa.add(anVar);
        }
    }

    public void bJ(String str, String str2) {
        if (!v.aa(this.cWa) && this.cVV != null && this.cVV.aCD()) {
            int i = -1;
            for (an anVar : this.cWa) {
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
            this.cWa.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.cVV != null && this.cVV.aCD()) {
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
        if (aq.isEmpty(str) || this.cVV == null || !this.cVV.aCD()) {
            com.baidu.ubs.analytics.a.Hd(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.cVV == null || !this.cVV.aCD()) {
            com.baidu.ubs.analytics.a.He(str);
        }
    }

    public void mt(int i) {
        if (this.cVV != null) {
            this.cVV.mt(i);
        }
    }
}
