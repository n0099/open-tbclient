package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class a {
    private ArrayList<Integer> fYx;
    private c fYy;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fYx = arrayList;
        this.fYy = cVar;
    }

    public int ax(String str, int i) {
        if (this.mData == null || au.isEmpty(str) || this.fYx == null || !this.fYx.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Fm(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ul(i);
    }

    public void Fm(String str) {
        if (this.mData != null && !au.isEmpty(str) && this.fYy != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fYy.a(this.fYx, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fYy.a(this.fYx, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
