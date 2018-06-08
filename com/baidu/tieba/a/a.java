package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private HashMap<String, b> bkb = new HashMap<>();
    private ArrayList<Integer> bkc;
    private c bkd;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bkc = arrayList;
        this.bkd = cVar;
    }

    public int L(String str, int i) {
        if (this.bkb == null || ao.isEmpty(str) || this.bkc == null || !this.bkc.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bkb.containsKey(str)) {
            iw(str);
        }
        b bVar = this.bkb.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.go(i);
    }

    public void iw(String str) {
        if (this.bkb != null && !ao.isEmpty(str) && this.bkd != null) {
            if (this.bkb.containsKey(str)) {
                b bVar = this.bkb.get(str);
                this.bkd.a(this.bkc, bVar);
                this.bkb.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bkd.a(this.bkc, bVar2);
            this.bkb.put(str, bVar2);
        }
    }
}
