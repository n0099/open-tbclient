package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cUA;
    private a cUB;
    private List<am> cUC;
    private ArrayList<Integer> cUw = new ArrayList<>();
    private c cUx;

    public static d aBn() {
        if (cUA == null) {
            synchronized (c.class) {
                if (cUA == null) {
                    cUA = new d();
                }
            }
        }
        return cUA;
    }

    private d() {
        this.cUw.add(1);
        this.cUw.add(2);
        this.cUx = new c();
        this.cUB = new a(this.cUx, this.cUw);
        mm(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_abtest_channel", 0));
    }

    public int ag(String str, int i) {
        if (this.cUB == null) {
            return 0;
        }
        return this.cUB.ag(str, i);
    }

    public void rU(String str) {
        if (this.cUB != null) {
            this.cUB.rT(str);
        }
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cUC == null) {
                this.cUC = new ArrayList();
            }
            this.cUC.add(amVar);
        }
    }

    public void bJ(String str, String str2) {
        if (!v.aa(this.cUC) && this.cUx != null && this.cUx.aBl()) {
            int i = -1;
            for (am amVar : this.cUC) {
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
            this.cUC.clear();
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.cUx != null && this.cUx.aBl()) {
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
        if (ap.isEmpty(str) || this.cUx == null || !this.cUx.aBl()) {
            com.baidu.ubs.analytics.a.Gh(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.cUx == null || !this.cUx.aBl()) {
            com.baidu.ubs.analytics.a.Gi(str);
        }
    }

    public void mm(int i) {
        if (this.cUx != null) {
            this.cUx.mm(i);
        }
    }
}
