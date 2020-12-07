package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class a {
    private ArrayList<Integer> fYv;
    private c fYw;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.fYv = arrayList;
        this.fYw = cVar;
    }

    public int ax(String str, int i) {
        if (this.mData == null || au.isEmpty(str) || this.fYv == null || !this.fYv.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Fm(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ul(i);
    }

    public void Fm(String str) {
        if (this.mData != null && !au.isEmpty(str) && this.fYw != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.fYw.a(this.fYv, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.fYw.a(this.fYv, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
