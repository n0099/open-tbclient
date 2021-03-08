package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> ghs;
    private c ght;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.ghs = arrayList;
        this.ght = cVar;
    }

    public int aB(String str, int i) {
        if (this.mData == null || au.isEmpty(str) || this.ghs == null || !this.ghs.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            EB(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sY(i);
    }

    public void EB(String str) {
        if (this.mData != null && !au.isEmpty(str) && this.ght != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.ght.a(this.ghs, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.ght.a(this.ghs, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
