package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private HashMap<String, b> bBe = new HashMap<>();
    private ArrayList<Integer> bBf;
    private c bBg;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bBf = arrayList;
        this.bBg = cVar;
    }

    public int N(String str, int i) {
        if (this.bBe == null || ao.isEmpty(str) || this.bBf == null || !this.bBf.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bBe.containsKey(str)) {
            jZ(str);
        }
        b bVar = this.bBe.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.hD(i);
    }

    public void jZ(String str) {
        if (this.bBe != null && !ao.isEmpty(str) && this.bBg != null) {
            if (this.bBe.containsKey(str)) {
                b bVar = this.bBe.get(str);
                this.bBg.a(this.bBf, bVar);
                this.bBe.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bBg.a(this.bBf, bVar2);
            this.bBe.put(str, bVar2);
        }
    }
}
