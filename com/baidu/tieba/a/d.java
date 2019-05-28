package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cUB;
    private a cUC;
    private List<am> cUD;
    private ArrayList<Integer> cUx = new ArrayList<>();
    private c cUy;

    public static d aBq() {
        if (cUB == null) {
            synchronized (c.class) {
                if (cUB == null) {
                    cUB = new d();
                }
            }
        }
        return cUB;
    }

    private d() {
        this.cUx.add(1);
        this.cUx.add(2);
        this.cUy = new c();
        this.cUC = new a(this.cUy, this.cUx);
        mm(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_abtest_channel", 0));
    }

    public int ag(String str, int i) {
        if (this.cUC == null) {
            return 0;
        }
        return this.cUC.ag(str, i);
    }

    public void rU(String str) {
        if (this.cUC != null) {
            this.cUC.rT(str);
        }
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cUD == null) {
                this.cUD = new ArrayList();
            }
            this.cUD.add(amVar);
        }
    }

    public void bJ(String str, String str2) {
        if (!v.aa(this.cUD) && this.cUy != null && this.cUy.aBo()) {
            int i = -1;
            for (am amVar : this.cUD) {
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
            this.cUD.clear();
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.cUy != null && this.cUy.aBo()) {
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
        if (ap.isEmpty(str) || this.cUy == null || !this.cUy.aBo()) {
            com.baidu.ubs.analytics.a.Gh(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.cUy == null || !this.cUy.aBo()) {
            com.baidu.ubs.analytics.a.Gi(str);
        }
    }

    public void mm(int i) {
        if (this.cUy != null) {
            this.cUy.mm(i);
        }
    }
}
