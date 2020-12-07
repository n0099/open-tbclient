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
    private static volatile d fYz;
    private a fYA;
    private List<ar> fYB;
    private ArrayList<Integer> fYv = new ArrayList<>();
    private c fYw;

    public static d bLT() {
        if (fYz == null) {
            synchronized (c.class) {
                if (fYz == null) {
                    fYz = new d();
                }
            }
        }
        return fYz;
    }

    private d() {
        this.fYv.add(1);
        this.fYv.add(2);
        this.fYw = new c();
        this.fYA = new a(this.fYw, this.fYv);
        uq(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ax(String str, int i) {
        if (this.fYA == null) {
            return 0;
        }
        return this.fYA.ax(str, i);
    }

    public void Fn(String str) {
        if (this.fYA != null) {
            this.fYA.Fm(str);
        }
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYB == null) {
                this.fYB = new ArrayList();
            }
            this.fYB.add(arVar);
        }
    }

    public void dS(String str, String str2) {
        if (!y.isEmpty(this.fYB) && this.fYw != null && this.fYw.bLR()) {
            int i = -1;
            for (ar arVar : this.fYB) {
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
            this.fYB.clear();
        }
    }

    public void a(String str, String str2, ar arVar) {
        if (arVar != null && this.fYw != null && this.fYw.bLR()) {
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
        if (au.isEmpty(str) || this.fYw == null || !this.fYw.bLR()) {
            com.baidu.ubs.analytics.a.XW(str);
        }
    }

    public void onPageEnd(String str) {
        if (au.isEmpty(str) || this.fYw == null || !this.fYw.bLR()) {
            com.baidu.ubs.analytics.a.XX(str);
        }
    }

    public void uq(int i) {
        if (this.fYw != null) {
            this.fYw.uq(i);
        }
    }
}
