package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> bbP;
    private c bbQ;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bbP = arrayList;
        this.bbQ = cVar;
    }

    public int L(String str, int i) {
        if (this.mData == null || an.isEmpty(str) || this.bbP == null || !this.bbP.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            hW(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.gn(i);
    }

    public void hW(String str) {
        if (this.mData != null && !an.isEmpty(str) && this.bbQ != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.bbQ.a(this.bbP, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bbQ.a(this.bbP, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
