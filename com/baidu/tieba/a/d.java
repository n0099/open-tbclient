package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes21.dex */
public class d {
    private static volatile d fYB;
    private a fYC;
    private List<ar> fYD;
    private ArrayList<Integer> fYx = new ArrayList<>();
    private c fYy;

    public static d bLU() {
        if (fYB == null) {
            synchronized (c.class) {
                if (fYB == null) {
                    fYB = new d();
                }
            }
        }
        return fYB;
    }

    private d() {
        this.fYx.add(1);
        this.fYx.add(2);
        this.fYy = new c();
        this.fYC = new a(this.fYy, this.fYx);
        uq(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ax(String str, int i) {
        if (this.fYC == null) {
            return 0;
        }
        return this.fYC.ax(str, i);
    }

    public void Fn(String str) {
        if (this.fYC != null) {
            this.fYC.Fm(str);
        }
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYD == null) {
                this.fYD = new ArrayList();
            }
            this.fYD.add(arVar);
        }
    }

    public void dS(String str, String str2) {
        if (!y.isEmpty(this.fYD) && this.fYy != null && this.fYy.bLS()) {
            int i = -1;
            for (ar arVar : this.fYD) {
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
            this.fYD.clear();
        }
    }

    public void a(String str, String str2, ar arVar) {
        if (arVar != null && this.fYy != null && this.fYy.bLS()) {
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
        if (au.isEmpty(str) || this.fYy == null || !this.fYy.bLS()) {
            com.baidu.ubs.analytics.a.XW(str);
        }
    }

    public void onPageEnd(String str) {
        if (au.isEmpty(str) || this.fYy == null || !this.fYy.bLS()) {
            com.baidu.ubs.analytics.a.XX(str);
        }
    }

    public void uq(int i) {
        if (this.fYy != null) {
            this.fYy.uq(i);
        }
    }
}
