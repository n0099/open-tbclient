package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class a {
    private ArrayList<Integer> fCs;
    private c fCt;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fCs = arrayList;
        this.fCt = cVar;
    }

    public int av(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.fCs == null || !this.fCs.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Eq(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sO(i);
    }

    public void Eq(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.fCt != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fCt.a(this.fCs, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fCt.a(this.fCs, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
