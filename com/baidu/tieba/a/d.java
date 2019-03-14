package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cMm;
    private ArrayList<Integer> cMi = new ArrayList<>();
    private c cMj;
    private a cMn;
    private List<am> cMo;

    public static d awk() {
        if (cMm == null) {
            synchronized (c.class) {
                if (cMm == null) {
                    cMm = new d();
                }
            }
        }
        return cMm;
    }

    private d() {
        this.cMi.add(1);
        this.cMi.add(2);
        this.cMj = new c();
        this.cMn = new a(this.cMj, this.cMi);
        ly(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int ak(String str, int i) {
        if (this.cMn == null) {
            return 0;
        }
        return this.cMn.ak(str, i);
    }

    public void qK(String str) {
        if (this.cMn != null) {
            this.cMn.qJ(str);
        }
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cMo == null) {
                this.cMo = new ArrayList();
            }
            this.cMo.add(amVar);
        }
    }

    public void bA(String str, String str2) {
        if (!v.T(this.cMo) && this.cMj != null && this.cMj.awi()) {
            int i = -1;
            for (am amVar : this.cMo) {
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
            this.cMo.clear();
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.cMj != null && this.cMj.awi()) {
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
        if (ap.isEmpty(str) || this.cMj == null || !this.cMj.awi()) {
            com.baidu.ubs.analytics.a.EN(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.cMj == null || !this.cMj.awi()) {
            com.baidu.ubs.analytics.a.EO(str);
        }
    }

    public void ly(int i) {
        if (this.cMj != null) {
            this.cMj.ly(i);
        }
    }
}
