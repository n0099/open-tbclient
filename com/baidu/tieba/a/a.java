package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private HashMap<String, b> brY = new HashMap<>();
    private ArrayList<Integer> brZ;
    private c bsa;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.brZ = arrayList;
        this.bsa = cVar;
    }

    public int L(String str, int i) {
        if (this.brY == null || ao.isEmpty(str) || this.brZ == null || !this.brZ.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.brY.containsKey(str)) {
            jb(str);
        }
        b bVar = this.brY.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.gT(i);
    }

    public void jb(String str) {
        if (this.brY != null && !ao.isEmpty(str) && this.bsa != null) {
            if (this.brY.containsKey(str)) {
                b bVar = this.brY.get(str);
                this.bsa.a(this.brZ, bVar);
                this.brY.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bsa.a(this.brZ, bVar2);
            this.brY.put(str, bVar2);
        }
    }
}
