package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes21.dex */
public class d {
    private static volatile d fKR;
    private ArrayList<Integer> fKN = new ArrayList<>();
    private c fKO;
    private a fKS;
    private List<aq> fKT;

    public static d bGs() {
        if (fKR == null) {
            synchronized (c.class) {
                if (fKR == null) {
                    fKR = new d();
                }
            }
        }
        return fKR;
    }

    private d() {
        this.fKN.add(1);
        this.fKN.add(2);
        this.fKO = new c();
        this.fKS = new a(this.fKO, this.fKN);
        te(com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int av(String str, int i) {
        if (this.fKS == null) {
            return 0;
        }
        return this.fKS.av(str, i);
    }

    public void EK(String str) {
        if (this.fKS != null) {
            this.fKS.EJ(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fKT == null) {
                this.fKT = new ArrayList();
            }
            this.fKT.add(aqVar);
        }
    }

    public void dM(String str, String str2) {
        if (!y.isEmpty(this.fKT) && this.fKO != null && this.fKO.bGq()) {
            int i = -1;
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    if (aqVar.getPosition() == 0) {
                        a(str, str2, aqVar);
                    } else if (i != aqVar.getPosition()) {
                        i = aqVar.getPosition();
                        a(str, str2, aqVar);
                    }
                    i = i;
                }
            }
            this.fKT.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.fKO != null && this.fKO.bGq()) {
            HashMap hashMap = new HashMap();
            List<Object> params = aqVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + aqVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (at.isEmpty(str) || this.fKO == null || !this.fKO.bGq()) {
            com.baidu.ubs.analytics.a.Wp(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.fKO == null || !this.fKO.bGq()) {
            com.baidu.ubs.analytics.a.Wq(str);
        }
    }

    public void te(int i) {
        if (this.fKO != null) {
            this.fKO.te(i);
        }
    }
}
