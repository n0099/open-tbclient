package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private HashMap<String, b> bAn = new HashMap<>();
    private ArrayList<Integer> bAo;
    private c bAp;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bAo = arrayList;
        this.bAp = cVar;
    }

    public int M(String str, int i) {
        if (this.bAn == null || ao.isEmpty(str) || this.bAo == null || !this.bAo.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bAn.containsKey(str)) {
            jI(str);
        }
        b bVar = this.bAn.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.hC(i);
    }

    public void jI(String str) {
        if (this.bAn != null && !ao.isEmpty(str) && this.bAp != null) {
            if (this.bAn.containsKey(str)) {
                b bVar = this.bAn.get(str);
                this.bAp.a(this.bAo, bVar);
                this.bAn.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bAp.a(this.bAo, bVar2);
            this.bAn.put(str, bVar2);
        }
    }
}
