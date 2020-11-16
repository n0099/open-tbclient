package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class a {
    private ArrayList<Integer> fQm;
    private c fQn;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fQm = arrayList;
        this.fQn = cVar;
    }

    public int aw(String str, int i) {
        if (this.mData == null || au.isEmpty(str) || this.fQm == null || !this.fQm.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Ey(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.tH(i);
    }

    public void Ey(String str) {
        if (this.mData != null && !au.isEmpty(str) && this.fQn != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fQn.a(this.fQm, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fQn.a(this.fQm, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
