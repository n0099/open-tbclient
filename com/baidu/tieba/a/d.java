package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cUC;
    private a cUD;
    private List<am> cUE;
    private ArrayList<Integer> cUy = new ArrayList<>();
    private c cUz;

    public static d aBq() {
        if (cUC == null) {
            synchronized (c.class) {
                if (cUC == null) {
                    cUC = new d();
                }
            }
        }
        return cUC;
    }

    private d() {
        this.cUy.add(1);
        this.cUy.add(2);
        this.cUz = new c();
        this.cUD = new a(this.cUz, this.cUy);
        mm(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_abtest_channel", 0));
    }

    public int ag(String str, int i) {
        if (this.cUD == null) {
            return 0;
        }
        return this.cUD.ag(str, i);
    }

    public void rT(String str) {
        if (this.cUD != null) {
            this.cUD.rS(str);
        }
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cUE == null) {
                this.cUE = new ArrayList();
            }
            this.cUE.add(amVar);
        }
    }

    public void bJ(String str, String str2) {
        if (!v.aa(this.cUE) && this.cUz != null && this.cUz.aBo()) {
            int i = -1;
            for (am amVar : this.cUE) {
                if (amVar != null) {
                    if (amVar.getPosition() == 0) {
                        a(str, str2, amVar);
                    } else if (i != amVar.getPosition()) {
                        i = amVar.getPosition();
                        a(str, str2, amVar);
                    }
                    i = i;
                }
            }
            this.cUE.clear();
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.cUz != null && this.cUz.aBo()) {
            HashMap hashMap = new HashMap();
            List<Object> params = amVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + amVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (ap.isEmpty(str) || this.cUz == null || !this.cUz.aBo()) {
            com.baidu.ubs.analytics.a.Gj(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.cUz == null || !this.cUz.aBo()) {
            com.baidu.ubs.analytics.a.Gk(str);
        }
    }

    public void mm(int i) {
        if (this.cUz != null) {
            this.cUz.mm(i);
        }
    }
}
