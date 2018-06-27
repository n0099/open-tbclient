package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private HashMap<String, b> blA = new HashMap<>();
    private ArrayList<Integer> blB;
    private c blC;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.blB = arrayList;
        this.blC = cVar;
    }

    public int L(String str, int i) {
        if (this.blA == null || ap.isEmpty(str) || this.blB == null || !this.blB.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.blA.containsKey(str)) {
            iB(str);
        }
        b bVar = this.blA.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.gp(i);
    }

    public void iB(String str) {
        if (this.blA != null && !ap.isEmpty(str) && this.blC != null) {
            if (this.blA.containsKey(str)) {
                b bVar = this.blA.get(str);
                this.blC.a(this.blB, bVar);
                this.blA.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.blC.a(this.blB, bVar2);
            this.blA.put(str, bVar2);
        }
    }
}
