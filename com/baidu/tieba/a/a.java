package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private ArrayList<Integer> dTk;
    private c dTl;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dTk = arrayList;
        this.dTl = cVar;
    }

    public int aj(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.dTk == null || !this.dTk.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            wo(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.nL(i);
    }

    public void wo(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.dTl != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.dTl.a(this.dTk, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dTl.a(this.dTk, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
