package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cWf;
    private ArrayList<Integer> cWb = new ArrayList<>();
    private c cWc;
    private a cWg;
    private List<an> cWh;

    public static d aCH() {
        if (cWf == null) {
            synchronized (c.class) {
                if (cWf == null) {
                    cWf = new d();
                }
            }
        }
        return cWf;
    }

    private d() {
        this.cWb.add(1);
        this.cWb.add(2);
        this.cWc = new c();
        this.cWg = new a(this.cWc, this.cWb);
        mu(com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_abtest_channel", 0));
    }

    public int ag(String str, int i) {
        if (this.cWg == null) {
            return 0;
        }
        return this.cWg.ag(str, i);
    }

    public void sl(String str) {
        if (this.cWg != null) {
            this.cWg.sk(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.cWh == null) {
                this.cWh = new ArrayList();
            }
            this.cWh.add(anVar);
        }
    }

    public void bJ(String str, String str2) {
        if (!v.aa(this.cWh) && this.cWc != null && this.cWc.aCF()) {
            int i = -1;
            for (an anVar : this.cWh) {
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
            this.cWh.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.cWc != null && this.cWc.aCF()) {
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
        if (aq.isEmpty(str) || this.cWc == null || !this.cWc.aCF()) {
            com.baidu.ubs.analytics.a.He(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.cWc == null || !this.cWc.aCF()) {
            com.baidu.ubs.analytics.a.Hf(str);
        }
    }

    public void mu(int i) {
        if (this.cWc != null) {
            this.cWc.mu(i);
        }
    }
}
