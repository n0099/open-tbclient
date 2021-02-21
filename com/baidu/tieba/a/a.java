package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> gfP;
    private c gfQ;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.gfP = arrayList;
        this.gfQ = cVar;
    }

    public int aB(String str, int i) {
        if (this.mData == null || au.isEmpty(str) || this.gfP == null || !this.gfP.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Eu(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sW(i);
    }

    public void Eu(String str) {
        if (this.mData != null && !au.isEmpty(str) && this.gfQ != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.gfQ.a(this.gfP, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.gfQ.a(this.gfP, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
