package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> eMP;
    private c eMQ;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.eMP = arrayList;
        this.eMQ = cVar;
    }

    public int as(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.eMP == null || !this.eMP.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            zJ(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.pa(i);
    }

    public void zJ(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.eMQ != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.eMQ.a(this.eMP, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.eMQ.a(this.eMP, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
