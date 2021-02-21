package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d gfT;
    private ArrayList<Integer> gfP = new ArrayList<>();
    private c gfQ;
    private a gfU;
    private List<ar> gfV;

    public static d bKU() {
        if (gfT == null) {
            synchronized (c.class) {
                if (gfT == null) {
                    gfT = new d();
                }
            }
        }
        return gfT;
    }

    private d() {
        this.gfP.add(1);
        this.gfP.add(2);
        this.gfQ = new c();
        this.gfU = new a(this.gfQ, this.gfP);
        setChannel(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int aB(String str, int i) {
        if (this.gfU == null) {
            return 0;
        }
        return this.gfU.aB(str, i);
    }

    public void Ev(String str) {
        if (this.gfU != null) {
            this.gfU.Eu(str);
        }
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfV == null) {
                this.gfV = new ArrayList();
            }
            this.gfV.add(arVar);
        }
    }

    public void dK(String str, String str2) {
        if (!y.isEmpty(this.gfV) && this.gfQ != null && this.gfQ.bKS()) {
            int i = -1;
            for (ar arVar : this.gfV) {
                if (arVar != null) {
                    if (arVar.getPosition() == 0) {
                        a(str, str2, arVar);
                    } else if (i != arVar.getPosition()) {
                        i = arVar.getPosition();
                        a(str, str2, arVar);
                    }
                    i = i;
                }
            }
            this.gfV.clear();
        }
    }

    public void a(String str, String str2, ar arVar) {
        if (arVar != null && this.gfQ != null && this.gfQ.bKS()) {
            HashMap hashMap = new HashMap();
            List<Object> params = arVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + arVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (au.isEmpty(str) || this.gfQ == null || !this.gfQ.bKS()) {
            com.baidu.ubs.analytics.a.XI(str);
        }
    }

    public void onPageEnd(String str) {
        if (au.isEmpty(str) || this.gfQ == null || !this.gfQ.bKS()) {
            com.baidu.ubs.analytics.a.XJ(str);
        }
    }

    public void setChannel(int i) {
        if (this.gfQ != null) {
            this.gfQ.setChannel(i);
        }
    }
}
