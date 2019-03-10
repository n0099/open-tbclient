package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cMp;
    private ArrayList<Integer> cMl = new ArrayList<>();
    private c cMm;
    private a cMq;
    private List<am> cMr;

    public static d awl() {
        if (cMp == null) {
            synchronized (c.class) {
                if (cMp == null) {
                    cMp = new d();
                }
            }
        }
        return cMp;
    }

    private d() {
        this.cMl.add(1);
        this.cMl.add(2);
        this.cMm = new c();
        this.cMq = new a(this.cMm, this.cMl);
        ly(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int ak(String str, int i) {
        if (this.cMq == null) {
            return 0;
        }
        return this.cMq.ak(str, i);
    }

    public void qM(String str) {
        if (this.cMq != null) {
            this.cMq.qL(str);
        }
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cMr == null) {
                this.cMr = new ArrayList();
            }
            this.cMr.add(amVar);
        }
    }

    public void bA(String str, String str2) {
        if (!v.T(this.cMr) && this.cMm != null && this.cMm.awj()) {
            int i = -1;
            for (am amVar : this.cMr) {
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
            this.cMr.clear();
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.cMm != null && this.cMm.awj()) {
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
        if (ap.isEmpty(str) || this.cMm == null || !this.cMm.awj()) {
            com.baidu.ubs.analytics.a.EP(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.cMm == null || !this.cMm.awj()) {
            com.baidu.ubs.analytics.a.EQ(str);
        }
    }

    public void ly(int i) {
        if (this.cMm != null) {
            this.cMm.ly(i);
        }
    }
}
