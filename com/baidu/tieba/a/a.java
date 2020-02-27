package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> dXy;
    private c dXz;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dXy = arrayList;
        this.dXz = cVar;
    }

    public int ai(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.dXy == null || !this.dXy.contains(Integer.valueOf(i))) {
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
        if (this.mData != null && !aq.isEmpty(str) && this.dXz != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.dXz.a(this.dXy, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dXz.a(this.dXy, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
