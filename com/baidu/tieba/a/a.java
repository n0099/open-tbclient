package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> bbQ;
    private c bbR;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bbQ = arrayList;
        this.bbR = cVar;
    }

    public int L(String str, int i) {
        if (this.mData == null || an.isEmpty(str) || this.bbQ == null || !this.bbQ.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            hX(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.gn(i);
    }

    public void hX(String str) {
        if (this.mData != null && !an.isEmpty(str) && this.bbR != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.bbR.a(this.bbQ, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bbR.a(this.bbQ, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
