package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private static volatile d eMT;
    private ArrayList<Integer> eMP = new ArrayList<>();
    private c eMQ;
    private a eMU;
    private List<an> eMV;

    public static d bmb() {
        if (eMT == null) {
            synchronized (c.class) {
                if (eMT == null) {
                    eMT = new d();
                }
            }
        }
        return eMT;
    }

    private d() {
        this.eMP.add(1);
        this.eMP.add(2);
        this.eMQ = new c();
        this.eMU = new a(this.eMQ, this.eMP);
        pf(com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int as(String str, int i) {
        if (this.eMU == null) {
            return 0;
        }
        return this.eMU.as(str, i);
    }

    public void zK(String str) {
        if (this.eMU != null) {
            this.eMU.zJ(str);
        }
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMV == null) {
                this.eMV = new ArrayList();
            }
            this.eMV.add(anVar);
        }
    }

    public void de(String str, String str2) {
        if (!v.isEmpty(this.eMV) && this.eMQ != null && this.eMQ.blZ()) {
            int i = -1;
            for (an anVar : this.eMV) {
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
            this.eMV.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.eMQ != null && this.eMQ.blZ()) {
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
        if (aq.isEmpty(str) || this.eMQ == null || !this.eMQ.blZ()) {
            com.baidu.ubs.analytics.a.Po(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.eMQ == null || !this.eMQ.blZ()) {
            com.baidu.ubs.analytics.a.Pp(str);
        }
    }

    public void pf(int i) {
        if (this.eMQ != null) {
            this.eMQ.pf(i);
        }
    }
}
