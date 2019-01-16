package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d bBi;
    private ArrayList<Integer> bBe = new ArrayList<>();
    private c bBf;
    private a bBj;

    public static d Wk() {
        if (bBi == null) {
            synchronized (c.class) {
                if (bBi == null) {
                    bBi = new d();
                }
            }
        }
        return bBi;
    }

    private d() {
        this.bBe.add(1);
        this.bBe.add(2);
        this.bBf = new c();
        this.bBj = new a(this.bBf, this.bBe);
        hI(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int N(String str, int i) {
        if (this.bBj == null) {
            return 0;
        }
        return this.bBj.N(str, i);
    }

    public void ka(String str) {
        if (this.bBj != null) {
            this.bBj.jZ(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bBf != null && this.bBf.Wi()) {
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
        if (ao.isEmpty(str) || this.bBf == null || !this.bBf.Wi()) {
            com.baidu.ubs.analytics.a.yK(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bBf == null || !this.bBf.Wi()) {
            com.baidu.ubs.analytics.a.yL(str);
        }
    }

    public void hI(int i) {
        if (this.bBf != null) {
            this.bBf.hI(i);
        }
    }
}
