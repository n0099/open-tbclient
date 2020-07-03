package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> eXb;
    private c eXc;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.eXb = arrayList;
        this.eXc = cVar;
    }

    public int as(String str, int i) {
        if (this.mData == null || ar.isEmpty(str) || this.eXb == null || !this.eXb.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Ac(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.pz(i);
    }

    public void Ac(String str) {
        if (this.mData != null && !ar.isEmpty(str) && this.eXc != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.eXc.a(this.eXb, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.eXc.a(this.eXb, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
