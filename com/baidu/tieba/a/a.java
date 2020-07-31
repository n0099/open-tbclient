package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes15.dex */
public class a {
    private ArrayList<Integer> fbC;
    private c fbD;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fbC = arrayList;
        this.fbD = cVar;
    }

    public int ar(String str, int i) {
        if (this.mData == null || as.isEmpty(str) || this.fbC == null || !this.fbC.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            AN(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.pM(i);
    }

    public void AN(String str) {
        if (this.mData != null && !as.isEmpty(str) && this.fbD != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fbD.a(this.fbC, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fbD.a(this.fbC, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
