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
    private static volatile d fQH;
    private ArrayList<Integer> fQD = new ArrayList<>();
    private c fQE;
    private a fQI;
    private List<aq> fQJ;

    public static d bIR() {
        if (fQH == null) {
            synchronized (c.class) {
                if (fQH == null) {
                    fQH = new d();
                }
            }
        }
        return fQH;
    }

    private d() {
        this.fQD.add(1);
        this.fQD.add(2);
        this.fQE = new c();
        this.fQI = new a(this.fQE, this.fQD);
        to(com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ax(String str, int i) {
        if (this.fQI == null) {
            return 0;
        }
        return this.fQI.ax(str, i);
    }

    public void EY(String str) {
        if (this.fQI != null) {
            this.fQI.EX(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fQJ == null) {
                this.fQJ = new ArrayList();
            }
            this.fQJ.add(aqVar);
        }
    }

    public void dM(String str, String str2) {
        if (!y.isEmpty(this.fQJ) && this.fQE != null && this.fQE.bIP()) {
            int i = -1;
            for (aq aqVar : this.fQJ) {
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
            this.fQJ.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.fQE != null && this.fQE.bIP()) {
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
        if (at.isEmpty(str) || this.fQE == null || !this.fQE.bIP()) {
            com.baidu.ubs.analytics.a.WS(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.fQE == null || !this.fQE.bIP()) {
            com.baidu.ubs.analytics.a.WT(str);
        }
    }

    public void to(int i) {
        if (this.fQE != null) {
            this.fQE.to(i);
        }
    }
}
