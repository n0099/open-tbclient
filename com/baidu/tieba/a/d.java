package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d bAs;
    private ArrayList<Integer> bAo = new ArrayList<>();
    private c bAp;
    private a bAt;

    public static d VM() {
        if (bAs == null) {
            synchronized (c.class) {
                if (bAs == null) {
                    bAs = new d();
                }
            }
        }
        return bAs;
    }

    private d() {
        this.bAo.add(1);
        this.bAo.add(2);
        this.bAp = new c();
        this.bAt = new a(this.bAp, this.bAo);
        hH(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int M(String str, int i) {
        if (this.bAt == null) {
            return 0;
        }
        return this.bAt.M(str, i);
    }

    public void jJ(String str) {
        if (this.bAt != null) {
            this.bAt.jI(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bAp != null && this.bAp.VK()) {
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
        if (ao.isEmpty(str) || this.bAp == null || !this.bAp.VK()) {
            com.baidu.ubs.analytics.a.yr(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bAp == null || !this.bAp.VK()) {
            com.baidu.ubs.analytics.a.ys(str);
        }
    }

    public void hH(int i) {
        if (this.bAp != null) {
            this.bAp.hH(i);
        }
    }
}
