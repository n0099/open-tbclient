package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<Integer> eyc;
    private c eyd;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.eyc = arrayList;
        this.eyd = cVar;
    }

    public int ar(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.eyc == null || !this.eyc.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            yd(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.or(i);
    }

    public void yd(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.eyd != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.eyd.a(this.eyc, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.eyd.a(this.eyc, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
