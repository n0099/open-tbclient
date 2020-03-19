package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> dYc;
    private c dYd;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dYc = arrayList;
        this.dYd = cVar;
    }

    public int ai(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.dYc == null || !this.dYc.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            wO(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.oe(i);
    }

    public void wO(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.dYd != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.dYd.a(this.dYc, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dYd.a(this.dYc, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
