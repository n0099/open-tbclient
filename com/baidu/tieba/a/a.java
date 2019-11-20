package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> aDt = new HashMap<>();
    private c dfA;
    private ArrayList<Integer> dfz;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dfz = arrayList;
        this.dfA = cVar;
    }

    public int X(String str, int i) {
        if (this.aDt == null || aq.isEmpty(str) || this.dfz == null || !this.dfz.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.aDt.containsKey(str)) {
            rf(str);
        }
        b bVar = this.aDt.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.lx(i);
    }

    public void rf(String str) {
        if (this.aDt != null && !aq.isEmpty(str) && this.dfA != null) {
            if (this.aDt.containsKey(str)) {
                b bVar = this.aDt.get(str);
                this.dfA.a(this.dfz, bVar);
                this.aDt.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dfA.a(this.dfz, bVar2);
            this.aDt.put(str, bVar2);
        }
    }
}
