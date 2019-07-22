package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> ajR = new HashMap<>();
    private ArrayList<Integer> cVU;
    private c cVV;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cVU = arrayList;
        this.cVV = cVar;
    }

    public int ag(String str, int i) {
        if (this.ajR == null || aq.isEmpty(str) || this.cVU == null || !this.cVU.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.ajR.containsKey(str)) {
            sk(str);
        }
        b bVar = this.ajR.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.mo(i);
    }

    public void sk(String str) {
        if (this.ajR != null && !aq.isEmpty(str) && this.cVV != null) {
            if (this.ajR.containsKey(str)) {
                b bVar = this.ajR.get(str);
                this.cVV.a(this.cVU, bVar);
                this.ajR.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cVV.a(this.cVU, bVar2);
            this.ajR.put(str, bVar2);
        }
    }
}
