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
    private static volatile d dYg;
    private ArrayList<Integer> dYc = new ArrayList<>();
    private c dYd;
    private a dYh;
    private List<an> dYi;

    public static d aXK() {
        if (dYg == null) {
            synchronized (c.class) {
                if (dYg == null) {
                    dYg = new d();
                }
            }
        }
        return dYg;
    }

    private d() {
        this.dYc.add(1);
        this.dYc.add(2);
        this.dYd = new c();
        this.dYh = new a(this.dYd, this.dYc);
        oj(com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ai(String str, int i) {
        if (this.dYh == null) {
            return 0;
        }
        return this.dYh.ai(str, i);
    }

    public void wP(String str) {
        if (this.dYh != null) {
            this.dYh.wO(str);
        }
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.dYi == null) {
                this.dYi = new ArrayList();
            }
            this.dYi.add(anVar);
        }
    }

    public void cu(String str, String str2) {
        if (!v.isEmpty(this.dYi) && this.dYd != null && this.dYd.aXI()) {
            int i = -1;
            for (an anVar : this.dYi) {
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
            this.dYi.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dYd != null && this.dYd.aXI()) {
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
        if (aq.isEmpty(str) || this.dYd == null || !this.dYd.aXI()) {
            com.baidu.ubs.analytics.a.Lj(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dYd == null || !this.dYd.aXI()) {
            com.baidu.ubs.analytics.a.Lk(str);
        }
    }

    public void oj(int i) {
        if (this.dYd != null) {
            this.dYd.oj(i);
        }
    }
}
