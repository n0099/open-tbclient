package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes20.dex */
public class d {
    private static volatile d fqj;
    private ArrayList<Integer> fqf = new ArrayList<>();
    private c fqg;
    private a fqk;
    private List<aq> fql;

    public static d bBN() {
        if (fqj == null) {
            synchronized (c.class) {
                if (fqj == null) {
                    fqj = new d();
                }
            }
        }
        return fqj;
    }

    private d() {
        this.fqf.add(1);
        this.fqf.add(2);
        this.fqg = new c();
        this.fqk = new a(this.fqg, this.fqf);
        sv(com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int au(String str, int i) {
        if (this.fqk == null) {
            return 0;
        }
        return this.fqk.au(str, i);
    }

    public void DG(String str) {
        if (this.fqk != null) {
            this.fqk.DF(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fql == null) {
                this.fql = new ArrayList();
            }
            this.fql.add(aqVar);
        }
    }

    public void dA(String str, String str2) {
        if (!y.isEmpty(this.fql) && this.fqg != null && this.fqg.bBL()) {
            int i = -1;
            for (aq aqVar : this.fql) {
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
            this.fql.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.fqg != null && this.fqg.bBL()) {
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
        if (at.isEmpty(str) || this.fqg == null || !this.fqg.bBL()) {
            com.baidu.ubs.analytics.a.Un(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.fqg == null || !this.fqg.bBL()) {
            com.baidu.ubs.analytics.a.Uo(str);
        }
    }

    public void sv(int i) {
        if (this.fqg != null) {
            this.fqg.sv(i);
        }
    }
}
