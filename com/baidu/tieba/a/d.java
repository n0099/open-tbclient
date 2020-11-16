package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes20.dex */
public class d {
    private static volatile d fQq;
    private ArrayList<Integer> fQm = new ArrayList<>();
    private c fQn;
    private a fQr;
    private List<ar> fQs;

    public static d bIl() {
        if (fQq == null) {
            synchronized (c.class) {
                if (fQq == null) {
                    fQq = new d();
                }
            }
        }
        return fQq;
    }

    private d() {
        this.fQm.add(1);
        this.fQm.add(2);
        this.fQn = new c();
        this.fQr = new a(this.fQn, this.fQm);
        tM(com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int aw(String str, int i) {
        if (this.fQr == null) {
            return 0;
        }
        return this.fQr.aw(str, i);
    }

    public void Ez(String str) {
        if (this.fQr != null) {
            this.fQr.Ey(str);
        }
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fQs == null) {
                this.fQs = new ArrayList();
            }
            this.fQs.add(arVar);
        }
    }

    public void dL(String str, String str2) {
        if (!y.isEmpty(this.fQs) && this.fQn != null && this.fQn.bIj()) {
            int i = -1;
            for (ar arVar : this.fQs) {
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
            this.fQs.clear();
        }
    }

    public void a(String str, String str2, ar arVar) {
        if (arVar != null && this.fQn != null && this.fQn.bIj()) {
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
        if (au.isEmpty(str) || this.fQn == null || !this.fQn.bIj()) {
            com.baidu.ubs.analytics.a.WD(str);
        }
    }

    public void onPageEnd(String str) {
        if (au.isEmpty(str) || this.fQn == null || !this.fQn.bIj()) {
            com.baidu.ubs.analytics.a.WE(str);
        }
    }

    public void tM(int i) {
        if (this.fQn != null) {
            this.fQn.tM(i);
        }
    }
}
