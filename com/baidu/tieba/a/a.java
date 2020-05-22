package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> eME;
    private c eMF;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.eME = arrayList;
        this.eMF = cVar;
    }

    public int as(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.eME == null || !this.eME.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            zJ(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.oY(i);
    }

    public void zJ(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.eMF != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.eMF.a(this.eME, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.eMF.a(this.eME, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
