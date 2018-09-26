package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bsd;
    private ArrayList<Integer> brZ = new ArrayList<>();
    private c bsa;
    private a bse;

    public static d SB() {
        if (bsd == null) {
            synchronized (c.class) {
                if (bsd == null) {
                    bsd = new d();
                }
            }
        }
        return bsd;
    }

    private d() {
        this.brZ.add(1);
        this.brZ.add(2);
        this.bsa = new c();
        this.bse = new a(this.bsa, this.brZ);
        gY(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int L(String str, int i) {
        if (this.bse == null) {
            return 0;
        }
        return this.bse.L(str, i);
    }

    public void jc(String str) {
        if (this.bse != null) {
            this.bse.jb(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bsa != null && this.bsa.Sz()) {
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
        if (ao.isEmpty(str) || this.bsa == null || !this.bsa.Sz()) {
            com.baidu.ubs.analytics.a.wJ(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bsa == null || !this.bsa.Sz()) {
            com.baidu.ubs.analytics.a.wK(str);
        }
    }

    public void gY(int i) {
        if (this.bsa != null) {
            this.bsa.gY(i);
        }
    }
}
