package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes15.dex */
public class a {
    private ArrayList<Integer> fmW;
    private c fmX;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fmW = arrayList;
        this.fmX = cVar;
    }

    public int au(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.fmW == null || !this.fmW.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Dh(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.rY(i);
    }

    public void Dh(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.fmX != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fmX.a(this.fmW, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fmX.a(this.fmW, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
