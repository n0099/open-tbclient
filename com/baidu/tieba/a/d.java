package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cMo;
    private ArrayList<Integer> cMk = new ArrayList<>();
    private c cMl;
    private a cMp;
    private List<am> cMq;

    public static d awh() {
        if (cMo == null) {
            synchronized (c.class) {
                if (cMo == null) {
                    cMo = new d();
                }
            }
        }
        return cMo;
    }

    private d() {
        this.cMk.add(1);
        this.cMk.add(2);
        this.cMl = new c();
        this.cMp = new a(this.cMl, this.cMk);
        lx(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int ak(String str, int i) {
        if (this.cMp == null) {
            return 0;
        }
        return this.cMp.ak(str, i);
    }

    public void qL(String str) {
        if (this.cMp != null) {
            this.cMp.qK(str);
        }
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cMq == null) {
                this.cMq = new ArrayList();
            }
            this.cMq.add(amVar);
        }
    }

    public void bA(String str, String str2) {
        if (!v.T(this.cMq) && this.cMl != null && this.cMl.awf()) {
            int i = -1;
            for (am amVar : this.cMq) {
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
            this.cMq.clear();
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.cMl != null && this.cMl.awf()) {
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
        if (ap.isEmpty(str) || this.cMl == null || !this.cMl.awf()) {
            com.baidu.ubs.analytics.a.EM(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.cMl == null || !this.cMl.awf()) {
            com.baidu.ubs.analytics.a.EN(str);
        }
    }

    public void lx(int i) {
        if (this.cMl != null) {
            this.cMl.lx(i);
        }
    }
}
