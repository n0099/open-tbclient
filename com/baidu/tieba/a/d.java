package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d blF;
    private ArrayList<Integer> blB = new ArrayList<>();
    private c blC;
    private a blG;

    public static d QB() {
        if (blF == null) {
            synchronized (c.class) {
                if (blF == null) {
                    blF = new d();
                }
            }
        }
        return blF;
    }

    private d() {
        this.blB.add(1);
        this.blB.add(2);
        this.blC = new c();
        this.blG = new a(this.blC, this.blB);
        gu(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int L(String str, int i) {
        if (this.blG == null) {
            return 0;
        }
        return this.blG.L(str, i);
    }

    public void iC(String str) {
        if (this.blG != null) {
            this.blG.iB(str);
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.blC != null && this.blC.Qz()) {
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
        if (ap.isEmpty(str) || this.blC == null || !this.blC.Qz()) {
            com.baidu.ubs.analytics.a.vT(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.blC == null || !this.blC.Qz()) {
            com.baidu.ubs.analytics.a.vU(str);
        }
    }

    public void gu(int i) {
        if (this.blC != null) {
            this.blC.gu(i);
        }
    }
}
