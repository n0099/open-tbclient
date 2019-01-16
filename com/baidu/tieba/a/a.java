package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private HashMap<String, b> bBd = new HashMap<>();
    private ArrayList<Integer> bBe;
    private c bBf;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bBe = arrayList;
        this.bBf = cVar;
    }

    public int N(String str, int i) {
        if (this.bBd == null || ao.isEmpty(str) || this.bBe == null || !this.bBe.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bBd.containsKey(str)) {
            jZ(str);
        }
        b bVar = this.bBd.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.hD(i);
    }

    public void jZ(String str) {
        if (this.bBd != null && !ao.isEmpty(str) && this.bBf != null) {
            if (this.bBd.containsKey(str)) {
                b bVar = this.bBd.get(str);
                this.bBf.a(this.bBe, bVar);
                this.bBd.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bBf.a(this.bBe, bVar2);
            this.bBd.put(str, bVar2);
        }
    }
}
