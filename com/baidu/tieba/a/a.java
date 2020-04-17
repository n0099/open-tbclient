package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> exX;
    private c exY;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.exX = arrayList;
        this.exY = cVar;
    }

    public int ar(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.exX == null || !this.exX.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            ya(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.or(i);
    }

    public void ya(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.exY != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.exY.a(this.exX, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.exY.a(this.exX, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
