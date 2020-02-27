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
    private static volatile d dXC;
    private a dXD;
    private List<an> dXE;
    private ArrayList<Integer> dXy = new ArrayList<>();
    private c dXz;

    public static d aXD() {
        if (dXC == null) {
            synchronized (c.class) {
                if (dXC == null) {
                    dXC = new d();
                }
            }
        }
        return dXC;
    }

    private d() {
        this.dXy.add(1);
        this.dXy.add(2);
        this.dXz = new c();
        this.dXD = new a(this.dXz, this.dXy);
        oh(com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ai(String str, int i) {
        if (this.dXD == null) {
            return 0;
        }
        return this.dXD.ai(str, i);
    }

    public void wN(String str) {
        if (this.dXD != null) {
            this.dXD.wM(str);
        }
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXE == null) {
                this.dXE = new ArrayList();
            }
            this.dXE.add(anVar);
        }
    }

    public void cv(String str, String str2) {
        if (!v.isEmpty(this.dXE) && this.dXz != null && this.dXz.aXB()) {
            int i = -1;
            for (an anVar : this.dXE) {
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
            this.dXE.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dXz != null && this.dXz.aXB()) {
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
        if (aq.isEmpty(str) || this.dXz == null || !this.dXz.aXB()) {
            com.baidu.ubs.analytics.a.Li(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dXz == null || !this.dXz.aXB()) {
            com.baidu.ubs.analytics.a.Lj(str);
        }
    }

    public void oh(int i) {
        if (this.dXz != null) {
            this.dXz.oh(i);
        }
    }
}
