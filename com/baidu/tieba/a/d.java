package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bmp;
    private ArrayList<Integer> bml = new ArrayList<>();
    private c bmm;
    private a bmq;

    public static d QN() {
        if (bmp == null) {
            synchronized (c.class) {
                if (bmp == null) {
                    bmp = new d();
                }
            }
        }
        return bmp;
    }

    private d() {
        this.bml.add(1);
        this.bml.add(2);
        this.bmm = new c();
        this.bmq = new a(this.bmm, this.bml);
        gy(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int G(String str, int i) {
        if (this.bmq == null) {
            return 0;
        }
        return this.bmq.G(str, i);
    }

    public void iA(String str) {
        if (this.bmq != null) {
            this.bmq.iz(str);
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.bmm != null && this.bmm.QL()) {
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
        if (ap.isEmpty(str) || this.bmm == null || !this.bmm.QL()) {
            com.baidu.ubs.analytics.a.vY(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.bmm == null || !this.bmm.QL()) {
            com.baidu.ubs.analytics.a.vZ(str);
        }
    }

    public void gy(int i) {
        if (this.bmm != null) {
            this.bmm.gy(i);
        }
    }
}
