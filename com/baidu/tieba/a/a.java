package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private HashMap<String, b> bwQ = new HashMap<>();
    private ArrayList<Integer> bwR;
    private c bwS;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bwR = arrayList;
        this.bwS = cVar;
    }

    public int M(String str, int i) {
        if (this.bwQ == null || ao.isEmpty(str) || this.bwR == null || !this.bwR.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bwQ.containsKey(str)) {
            jq(str);
        }
        b bVar = this.bwQ.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ho(i);
    }

    public void jq(String str) {
        if (this.bwQ != null && !ao.isEmpty(str) && this.bwS != null) {
            if (this.bwQ.containsKey(str)) {
                b bVar = this.bwQ.get(str);
                this.bwS.a(this.bwR, bVar);
                this.bwQ.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bwS.a(this.bwR, bVar2);
            this.bwQ.put(str, bVar2);
        }
    }
}
