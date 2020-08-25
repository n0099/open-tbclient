package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes15.dex */
public class d {
    private static volatile d fna;
    private ArrayList<Integer> fmW = new ArrayList<>();
    private c fmX;
    private a fnb;
    private List<aq> fnc;

    public static d bAA() {
        if (fna == null) {
            synchronized (c.class) {
                if (fna == null) {
                    fna = new d();
                }
            }
        }
        return fna;
    }

    private d() {
        this.fmW.add(1);
        this.fmW.add(2);
        this.fmX = new c();
        this.fnb = new a(this.fmX, this.fmW);
        sd(com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int au(String str, int i) {
        if (this.fnb == null) {
            return 0;
        }
        return this.fnb.au(str, i);
    }

    public void Di(String str) {
        if (this.fnb != null) {
            this.fnb.Dh(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fnc == null) {
                this.fnc = new ArrayList();
            }
            this.fnc.add(aqVar);
        }
    }

    public void dA(String str, String str2) {
        if (!y.isEmpty(this.fnc) && this.fmX != null && this.fmX.bAy()) {
            int i = -1;
            for (aq aqVar : this.fnc) {
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
            this.fnc.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.fmX != null && this.fmX.bAy()) {
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
        if (at.isEmpty(str) || this.fmX == null || !this.fmX.bAy()) {
            com.baidu.ubs.analytics.a.TL(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.fmX == null || !this.fmX.bAy()) {
            com.baidu.ubs.analytics.a.TM(str);
        }
    }

    public void sd(int i) {
        if (this.fmX != null) {
            this.fmX.sd(i);
        }
    }
}
