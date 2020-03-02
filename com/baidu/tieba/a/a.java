package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private c dXA;
    private ArrayList<Integer> dXz;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dXz = arrayList;
        this.dXA = cVar;
    }

    public int ai(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.dXz == null || !this.dXz.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            wM(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.oc(i);
    }

    public void wM(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.dXA != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.dXA.a(this.dXz, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dXA.a(this.dXz, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
