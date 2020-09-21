package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class a {
    private ArrayList<Integer> fqf;
    private c fqg;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fqf = arrayList;
        this.fqg = cVar;
    }

    public int au(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.fqf == null || !this.fqf.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            DF(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sq(i);
    }

    public void DF(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.fqg != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fqg.a(this.fqf, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fqg.a(this.fqf, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
