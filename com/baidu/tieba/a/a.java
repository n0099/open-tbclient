package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> gdv;
    private c gdw;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.gdv = arrayList;
        this.gdw = cVar;
    }

    public int az(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.gdv == null || !this.gdv.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            DY(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sR(i);
    }

    public void DY(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.gdw != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.gdw.a(this.gdv, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.gdw.a(this.gdv, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
