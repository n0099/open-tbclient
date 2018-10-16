package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private HashMap<String, b> bwf = new HashMap<>();
    private ArrayList<Integer> bwg;
    private c bwh;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bwg = arrayList;
        this.bwh = cVar;
    }

    public int M(String str, int i) {
        if (this.bwf == null || ao.isEmpty(str) || this.bwg == null || !this.bwg.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bwf.containsKey(str)) {
            jo(str);
        }
        b bVar = this.bwf.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.hb(i);
    }

    public void jo(String str) {
        if (this.bwf != null && !ao.isEmpty(str) && this.bwh != null) {
            if (this.bwf.containsKey(str)) {
                b bVar = this.bwf.get(str);
                this.bwh.a(this.bwg, bVar);
                this.bwf.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bwh.a(this.bwg, bVar2);
            this.bwf.put(str, bVar2);
        }
    }
}
