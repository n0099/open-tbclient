package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> aDL = new HashMap<>();
    private ArrayList<Integer> dgq;
    private c dgr;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dgq = arrayList;
        this.dgr = cVar;
    }

    public int X(String str, int i) {
        if (this.aDL == null || aq.isEmpty(str) || this.dgq == null || !this.dgq.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.aDL.containsKey(str)) {
            rf(str);
        }
        b bVar = this.aDL.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ly(i);
    }

    public void rf(String str) {
        if (this.aDL != null && !aq.isEmpty(str) && this.dgr != null) {
            if (this.aDL.containsKey(str)) {
                b bVar = this.aDL.get(str);
                this.dgr.a(this.dgq, bVar);
                this.aDL.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dgr.a(this.dgq, bVar2);
            this.aDL.put(str, bVar2);
        }
    }
}
