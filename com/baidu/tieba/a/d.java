package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static volatile d dfD;
    private c dfA;
    private a dfE;
    private List<an> dfF;
    private ArrayList<Integer> dfz = new ArrayList<>();

    public static d aDc() {
        if (dfD == null) {
            synchronized (c.class) {
                if (dfD == null) {
                    dfD = new d();
                }
            }
        }
        return dfD;
    }

    private d() {
        this.dfz.add(1);
        this.dfz.add(2);
        this.dfA = new c();
        this.dfE = new a(this.dfA, this.dfz);
        lC(com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int X(String str, int i) {
        if (this.dfE == null) {
            return 0;
        }
        return this.dfE.X(str, i);
    }

    public void rg(String str) {
        if (this.dfE != null) {
            this.dfE.rf(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dfF == null) {
                this.dfF = new ArrayList();
            }
            this.dfF.add(anVar);
        }
    }

    public void bO(String str, String str2) {
        if (!v.isEmpty(this.dfF) && this.dfA != null && this.dfA.aDa()) {
            int i = -1;
            for (an anVar : this.dfF) {
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
            this.dfF.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dfA != null && this.dfA.aDa()) {
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
        if (aq.isEmpty(str) || this.dfA == null || !this.dfA.aDa()) {
            com.baidu.ubs.analytics.a.FV(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dfA == null || !this.dfA.aDa()) {
            com.baidu.ubs.analytics.a.FW(str);
        }
    }

    public void lC(int i) {
        if (this.dfA != null) {
            this.dfA.lC(i);
        }
    }
}
