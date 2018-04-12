package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d bbU;
    private ArrayList<Integer> bbP = new ArrayList<>();
    private c bbQ;
    private a bbV;

    public static d MH() {
        if (bbU == null) {
            synchronized (c.class) {
                if (bbU == null) {
                    bbU = new d();
                }
            }
        }
        return bbU;
    }

    private d() {
        this.bbP.add(1);
        this.bbP.add(2);
        this.bbQ = new c();
        this.bbV = new a(this.bbQ, this.bbP);
    }

    public int L(String str, int i) {
        if (this.bbV == null) {
            return 0;
        }
        return this.bbV.L(str, i);
    }

    public void hX(String str) {
        if (this.bbV != null) {
            this.bbV.hW(str);
        }
    }

    public void a(String str, String str2, al alVar) {
        if (alVar != null && this.bbQ != null && this.bbQ.MF()) {
            HashMap hashMap = new HashMap();
            List<Object> params = alVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + alVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (an.isEmpty(str) || this.bbQ == null || !this.bbQ.MF()) {
            com.baidu.ubs.analytics.a.va(str);
        }
    }

    public void onPageEnd(String str) {
        if (an.isEmpty(str) || this.bbQ == null || !this.bbQ.MF()) {
            com.baidu.ubs.analytics.a.vb(str);
        }
    }

    public void gs(int i) {
        if (this.bbQ != null) {
            this.bbQ.gs(i);
        }
    }
}
