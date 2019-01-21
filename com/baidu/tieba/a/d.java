package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d bBj;
    private ArrayList<Integer> bBf = new ArrayList<>();
    private c bBg;
    private a bBk;

    public static d Wk() {
        if (bBj == null) {
            synchronized (c.class) {
                if (bBj == null) {
                    bBj = new d();
                }
            }
        }
        return bBj;
    }

    private d() {
        this.bBf.add(1);
        this.bBf.add(2);
        this.bBg = new c();
        this.bBk = new a(this.bBg, this.bBf);
        hI(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int N(String str, int i) {
        if (this.bBk == null) {
            return 0;
        }
        return this.bBk.N(str, i);
    }

    public void ka(String str) {
        if (this.bBk != null) {
            this.bBk.jZ(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bBg != null && this.bBg.Wi()) {
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
        if (ao.isEmpty(str) || this.bBg == null || !this.bBg.Wi()) {
            com.baidu.ubs.analytics.a.yK(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bBg == null || !this.bBg.Wi()) {
            com.baidu.ubs.analytics.a.yL(str);
        }
    }

    public void hI(int i) {
        if (this.bBg != null) {
            this.bBg.hI(i);
        }
    }
}
