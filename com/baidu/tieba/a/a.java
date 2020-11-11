package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class a {
    private ArrayList<Integer> fQD;
    private c fQE;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fQD = arrayList;
        this.fQE = cVar;
    }

    public int ax(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.fQD == null || !this.fQD.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            EX(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.tj(i);
    }

    public void EX(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.fQE != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fQE.a(this.fQD, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fQE.a(this.fQD, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
