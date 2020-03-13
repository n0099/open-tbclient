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
    private static volatile d dXQ;
    private ArrayList<Integer> dXM = new ArrayList<>();
    private c dXN;
    private a dXR;
    private List<an> dXS;

    public static d aXG() {
        if (dXQ == null) {
            synchronized (c.class) {
                if (dXQ == null) {
                    dXQ = new d();
                }
            }
        }
        return dXQ;
    }

    private d() {
        this.dXM.add(1);
        this.dXM.add(2);
        this.dXN = new c();
        this.dXR = new a(this.dXN, this.dXM);
        oh(com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ai(String str, int i) {
        if (this.dXR == null) {
            return 0;
        }
        return this.dXR.ai(str, i);
    }

    public void wO(String str) {
        if (this.dXR != null) {
            this.dXR.wN(str);
        }
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXS == null) {
                this.dXS = new ArrayList();
            }
            this.dXS.add(anVar);
        }
    }

    public void cv(String str, String str2) {
        if (!v.isEmpty(this.dXS) && this.dXN != null && this.dXN.aXE()) {
            int i = -1;
            for (an anVar : this.dXS) {
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
            this.dXS.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dXN != null && this.dXN.aXE()) {
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
        if (aq.isEmpty(str) || this.dXN == null || !this.dXN.aXE()) {
            com.baidu.ubs.analytics.a.Lj(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dXN == null || !this.dXN.aXE()) {
            com.baidu.ubs.analytics.a.Lk(str);
        }
    }

    public void oh(int i) {
        if (this.dXN != null) {
            this.dXN.oh(i);
        }
    }
}
