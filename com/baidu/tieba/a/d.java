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
    private static volatile d dXD;
    private c dXA;
    private a dXE;
    private List<an> dXF;
    private ArrayList<Integer> dXz = new ArrayList<>();

    public static d aXF() {
        if (dXD == null) {
            synchronized (c.class) {
                if (dXD == null) {
                    dXD = new d();
                }
            }
        }
        return dXD;
    }

    private d() {
        this.dXz.add(1);
        this.dXz.add(2);
        this.dXA = new c();
        this.dXE = new a(this.dXA, this.dXz);
        oh(com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ai(String str, int i) {
        if (this.dXE == null) {
            return 0;
        }
        return this.dXE.ai(str, i);
    }

    public void wN(String str) {
        if (this.dXE != null) {
            this.dXE.wM(str);
        }
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXF == null) {
                this.dXF = new ArrayList();
            }
            this.dXF.add(anVar);
        }
    }

    public void cv(String str, String str2) {
        if (!v.isEmpty(this.dXF) && this.dXA != null && this.dXA.aXD()) {
            int i = -1;
            for (an anVar : this.dXF) {
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
            this.dXF.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dXA != null && this.dXA.aXD()) {
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
        if (aq.isEmpty(str) || this.dXA == null || !this.dXA.aXD()) {
            com.baidu.ubs.analytics.a.Li(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dXA == null || !this.dXA.aXD()) {
            com.baidu.ubs.analytics.a.Lj(str);
        }
    }

    public void oh(int i) {
        if (this.dXA != null) {
            this.dXA.oh(i);
        }
    }
}
