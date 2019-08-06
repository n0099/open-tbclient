package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> ajR = new HashMap<>();
    private ArrayList<Integer> cWb;
    private c cWc;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cWb = arrayList;
        this.cWc = cVar;
    }

    public int ag(String str, int i) {
        if (this.ajR == null || aq.isEmpty(str) || this.cWb == null || !this.cWb.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.ajR.containsKey(str)) {
            sk(str);
        }
        b bVar = this.ajR.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.mp(i);
    }

    public void sk(String str) {
        if (this.ajR != null && !aq.isEmpty(str) && this.cWc != null) {
            if (this.ajR.containsKey(str)) {
                b bVar = this.ajR.get(str);
                this.cWc.a(this.cWb, bVar);
                this.ajR.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cWc.a(this.cWb, bVar2);
            this.ajR.put(str, bVar2);
        }
    }
}
