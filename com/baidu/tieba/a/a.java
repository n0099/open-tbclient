package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> dXM;
    private c dXN;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dXM = arrayList;
        this.dXN = cVar;
    }

    public int ai(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.dXM == null || !this.dXM.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            wN(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.oc(i);
    }

    public void wN(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.dXN != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.dXN.a(this.dXM, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dXN.a(this.dXM, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
