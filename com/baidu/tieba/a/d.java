package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bkg;
    private ArrayList<Integer> bkc = new ArrayList<>();
    private c bkd;
    private a bkh;

    public static d Qe() {
        if (bkg == null) {
            synchronized (c.class) {
                if (bkg == null) {
                    bkg = new d();
                }
            }
        }
        return bkg;
    }

    private d() {
        this.bkc.add(1);
        this.bkc.add(2);
        this.bkd = new c();
        this.bkh = new a(this.bkd, this.bkc);
        gt(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int L(String str, int i) {
        if (this.bkh == null) {
            return 0;
        }
        return this.bkh.L(str, i);
    }

    public void ix(String str) {
        if (this.bkh != null) {
            this.bkh.iw(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bkd != null && this.bkd.Qc()) {
            HashMap hashMap = new HashMap();
            List<Object> params = amVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + amVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (ao.isEmpty(str) || this.bkd == null || !this.bkd.Qc()) {
            com.baidu.ubs.analytics.a.vX(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bkd == null || !this.bkd.Qc()) {
            com.baidu.ubs.analytics.a.vY(str);
        }
    }

    public void gt(int i) {
        if (this.bkd != null) {
            this.bkd.gt(i);
        }
    }
}
