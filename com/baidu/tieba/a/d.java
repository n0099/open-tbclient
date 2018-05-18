package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d bbV;
    private ArrayList<Integer> bbQ = new ArrayList<>();
    private c bbR;
    private a bbW;

    public static d MF() {
        if (bbV == null) {
            synchronized (c.class) {
                if (bbV == null) {
                    bbV = new d();
                }
            }
        }
        return bbV;
    }

    private d() {
        this.bbQ.add(1);
        this.bbQ.add(2);
        this.bbR = new c();
        this.bbW = new a(this.bbR, this.bbQ);
    }

    public int L(String str, int i) {
        if (this.bbW == null) {
            return 0;
        }
        return this.bbW.L(str, i);
    }

    public void hY(String str) {
        if (this.bbW != null) {
            this.bbW.hX(str);
        }
    }

    public void a(String str, String str2, al alVar) {
        if (alVar != null && this.bbR != null && this.bbR.MD()) {
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
        if (an.isEmpty(str) || this.bbR == null || !this.bbR.MD()) {
            com.baidu.ubs.analytics.a.vd(str);
        }
    }

    public void onPageEnd(String str) {
        if (an.isEmpty(str) || this.bbR == null || !this.bbR.MD()) {
            com.baidu.ubs.analytics.a.ve(str);
        }
    }

    public void gs(int i) {
        if (this.bbR != null) {
            this.bbR.gs(i);
        }
    }
}
