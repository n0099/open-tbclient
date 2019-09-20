package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> akp = new HashMap<>();
    private ArrayList<Integer> cWU;
    private c cWV;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cWU = arrayList;
        this.cWV = cVar;
    }

    public int ag(String str, int i) {
        if (this.akp == null || aq.isEmpty(str) || this.cWU == null || !this.cWU.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.akp.containsKey(str)) {
            sw(str);
        }
        b bVar = this.akp.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.mt(i);
    }

    public void sw(String str) {
        if (this.akp != null && !aq.isEmpty(str) && this.cWV != null) {
            if (this.akp.containsKey(str)) {
                b bVar = this.akp.get(str);
                this.cWV.a(this.cWU, bVar);
                this.akp.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cWV.a(this.cWU, bVar2);
            this.akp.put(str, bVar2);
        }
    }
}
