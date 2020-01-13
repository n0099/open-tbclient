package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d dTx;
    private ArrayList<Integer> dTt = new ArrayList<>();
    private c dTu;
    private a dTy;
    private List<an> dTz;

    public static d aVo() {
        if (dTx == null) {
            synchronized (c.class) {
                if (dTx == null) {
                    dTx = new d();
                }
            }
        }
        return dTx;
    }

    private d() {
        this.dTt.add(1);
        this.dTt.add(2);
        this.dTu = new c();
        this.dTy = new a(this.dTu, this.dTt);
        nQ(com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ak(String str, int i) {
        if (this.dTy == null) {
            return 0;
        }
        return this.dTy.ak(str, i);
    }

    public void wt(String str) {
        if (this.dTy != null) {
            this.dTy.ws(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTz == null) {
                this.dTz = new ArrayList();
            }
            this.dTz.add(anVar);
        }
    }

    public void cm(String str, String str2) {
        if (!v.isEmpty(this.dTz) && this.dTu != null && this.dTu.aVm()) {
            int i = -1;
            for (an anVar : this.dTz) {
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
            this.dTz.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dTu != null && this.dTu.aVm()) {
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
        if (aq.isEmpty(str) || this.dTu == null || !this.dTu.aVm()) {
            com.baidu.ubs.analytics.a.KV(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dTu == null || !this.dTu.aVm()) {
            com.baidu.ubs.analytics.a.KW(str);
        }
    }

    public void nQ(int i) {
        if (this.dTu != null) {
            this.dTu.nQ(i);
        }
    }
}
