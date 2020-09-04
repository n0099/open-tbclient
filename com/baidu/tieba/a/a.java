package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes15.dex */
public class a {
    private ArrayList<Integer> fna;
    private c fnb;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fna = arrayList;
        this.fnb = cVar;
    }

    public int au(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.fna == null || !this.fna.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Di(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.rY(i);
    }

    public void Di(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.fnb != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fnb.a(this.fna, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fnb.a(this.fna, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
