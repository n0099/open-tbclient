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
    private static volatile d dgu;
    private ArrayList<Integer> dgq = new ArrayList<>();
    private c dgr;
    private a dgv;
    private List<an> dgw;

    public static d aDe() {
        if (dgu == null) {
            synchronized (c.class) {
                if (dgu == null) {
                    dgu = new d();
                }
            }
        }
        return dgu;
    }

    private d() {
        this.dgq.add(1);
        this.dgq.add(2);
        this.dgr = new c();
        this.dgv = new a(this.dgr, this.dgq);
        lD(com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int X(String str, int i) {
        if (this.dgv == null) {
            return 0;
        }
        return this.dgv.X(str, i);
    }

    public void rg(String str) {
        if (this.dgv != null) {
            this.dgv.rf(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dgw == null) {
                this.dgw = new ArrayList();
            }
            this.dgw.add(anVar);
        }
    }

    public void bO(String str, String str2) {
        if (!v.isEmpty(this.dgw) && this.dgr != null && this.dgr.aDc()) {
            int i = -1;
            for (an anVar : this.dgw) {
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
            this.dgw.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dgr != null && this.dgr.aDc()) {
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
        if (aq.isEmpty(str) || this.dgr == null || !this.dgr.aDc()) {
            com.baidu.ubs.analytics.a.FV(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dgr == null || !this.dgr.aDc()) {
            com.baidu.ubs.analytics.a.FW(str);
        }
    }

    public void lD(int i) {
        if (this.dgr != null) {
            this.dgr.lD(i);
        }
    }
}
