package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d bAv;
    private ArrayList<Integer> bAr = new ArrayList<>();
    private c bAs;
    private a bAw;

    public static d VO() {
        if (bAv == null) {
            synchronized (c.class) {
                if (bAv == null) {
                    bAv = new d();
                }
            }
        }
        return bAv;
    }

    private d() {
        this.bAr.add(1);
        this.bAr.add(2);
        this.bAs = new c();
        this.bAw = new a(this.bAs, this.bAr);
        hI(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int N(String str, int i) {
        if (this.bAw == null) {
            return 0;
        }
        return this.bAw.N(str, i);
    }

    public void jK(String str) {
        if (this.bAw != null) {
            this.bAw.jJ(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bAs != null && this.bAs.VM()) {
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
        if (ao.isEmpty(str) || this.bAs == null || !this.bAs.VM()) {
            com.baidu.ubs.analytics.a.yu(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bAs == null || !this.bAs.VM()) {
            com.baidu.ubs.analytics.a.yv(str);
        }
    }

    public void hI(int i) {
        if (this.bAs != null) {
            this.bAs.hI(i);
        }
    }
}
