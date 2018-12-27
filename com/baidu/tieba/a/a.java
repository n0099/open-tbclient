package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private HashMap<String, b> bAq = new HashMap<>();
    private ArrayList<Integer> bAr;
    private c bAs;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bAr = arrayList;
        this.bAs = cVar;
    }

    public int N(String str, int i) {
        if (this.bAq == null || ao.isEmpty(str) || this.bAr == null || !this.bAr.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bAq.containsKey(str)) {
            jJ(str);
        }
        b bVar = this.bAq.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.hD(i);
    }

    public void jJ(String str) {
        if (this.bAq != null && !ao.isEmpty(str) && this.bAs != null) {
            if (this.bAq.containsKey(str)) {
                b bVar = this.bAq.get(str);
                this.bAs.a(this.bAr, bVar);
                this.bAq.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bAs.a(this.bAr, bVar2);
            this.bAq.put(str, bVar2);
        }
    }
}
