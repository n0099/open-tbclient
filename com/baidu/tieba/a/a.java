package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> aiX = new HashMap<>();
    private ArrayList<Integer> cMi;
    private c cMj;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cMi = arrayList;
        this.cMj = cVar;
    }

    public int ak(String str, int i) {
        if (this.aiX == null || ap.isEmpty(str) || this.cMi == null || !this.cMi.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.aiX.containsKey(str)) {
            qJ(str);
        }
        b bVar = this.aiX.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.lt(i);
    }

    public void qJ(String str) {
        if (this.aiX != null && !ap.isEmpty(str) && this.cMj != null) {
            if (this.aiX.containsKey(str)) {
                b bVar = this.aiX.get(str);
                this.cMj.a(this.cMi, bVar);
                this.aiX.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cMj.a(this.cMi, bVar2);
            this.aiX.put(str, bVar2);
        }
    }
}
