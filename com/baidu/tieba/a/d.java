package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private static volatile d eXf;
    private ArrayList<Integer> eXb = new ArrayList<>();
    private c eXc;
    private a eXg;
    private List<ao> eXh;

    public static d boA() {
        if (eXf == null) {
            synchronized (c.class) {
                if (eXf == null) {
                    eXf = new d();
                }
            }
        }
        return eXf;
    }

    private d() {
        this.eXb.add(1);
        this.eXb.add(2);
        this.eXc = new c();
        this.eXg = new a(this.eXc, this.eXb);
        pE(com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int as(String str, int i) {
        if (this.eXg == null) {
            return 0;
        }
        return this.eXg.as(str, i);
    }

    public void Ad(String str) {
        if (this.eXg != null) {
            this.eXg.Ac(str);
        }
    }

    public void e(ao aoVar) {
        if (aoVar != null) {
            if (this.eXh == null) {
                this.eXh = new ArrayList();
            }
            this.eXh.add(aoVar);
        }
    }

    public void dh(String str, String str2) {
        if (!w.isEmpty(this.eXh) && this.eXc != null && this.eXc.boy()) {
            int i = -1;
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    if (aoVar.getPosition() == 0) {
                        a(str, str2, aoVar);
                    } else if (i != aoVar.getPosition()) {
                        i = aoVar.getPosition();
                        a(str, str2, aoVar);
                    }
                    i = i;
                }
            }
            this.eXh.clear();
        }
    }

    public void a(String str, String str2, ao aoVar) {
        if (aoVar != null && this.eXc != null && this.eXc.boy()) {
            HashMap hashMap = new HashMap();
            List<Object> params = aoVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + aoVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (ar.isEmpty(str) || this.eXc == null || !this.eXc.boy()) {
            com.baidu.ubs.analytics.a.Qa(str);
        }
    }

    public void onPageEnd(String str) {
        if (ar.isEmpty(str) || this.eXc == null || !this.eXc.boy()) {
            com.baidu.ubs.analytics.a.Qb(str);
        }
    }

    public void pE(int i) {
        if (this.eXc != null) {
            this.eXc.pE(i);
        }
    }
}
