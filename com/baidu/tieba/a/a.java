package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class a {
    private ArrayList<Integer> fKN;
    private c fKO;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fKN = arrayList;
        this.fKO = cVar;
    }

    public int av(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.fKN == null || !this.fKN.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            EJ(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sZ(i);
    }

    public void EJ(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.fKO != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fKO.a(this.fKN, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fKO.a(this.fKN, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
