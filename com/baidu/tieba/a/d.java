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
    private static volatile d fCw;
    private ArrayList<Integer> fCs = new ArrayList<>();
    private c fCt;
    private a fCx;
    private List<aq> fCy;

    public static d bEz() {
        if (fCw == null) {
            synchronized (c.class) {
                if (fCw == null) {
                    fCw = new d();
                }
            }
        }
        return fCw;
    }

    private d() {
        this.fCs.add(1);
        this.fCs.add(2);
        this.fCt = new c();
        this.fCx = new a(this.fCt, this.fCs);
        sT(com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int av(String str, int i) {
        if (this.fCx == null) {
            return 0;
        }
        return this.fCx.av(str, i);
    }

    public void Er(String str) {
        if (this.fCx != null) {
            this.fCx.Eq(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fCy == null) {
                this.fCy = new ArrayList();
            }
            this.fCy.add(aqVar);
        }
    }

    public void dF(String str, String str2) {
        if (!y.isEmpty(this.fCy) && this.fCt != null && this.fCt.bEx()) {
            int i = -1;
            for (aq aqVar : this.fCy) {
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
            this.fCy.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.fCt != null && this.fCt.bEx()) {
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
        if (at.isEmpty(str) || this.fCt == null || !this.fCt.bEx()) {
            com.baidu.ubs.analytics.a.Vb(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.fCt == null || !this.fCt.bEx()) {
            com.baidu.ubs.analytics.a.Vc(str);
        }
    }

    public void sT(int i) {
        if (this.fCt != null) {
            this.fCt.sT(i);
        }
    }
}
