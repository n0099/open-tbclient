package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> gie;
    private c gif;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.gie = arrayList;
        this.gif = cVar;
    }

    public int az(String str, int i) {
        if (this.mData == null || at.isEmpty(str) || this.gie == null || !this.gie.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Fk(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ux(i);
    }

    public void Fk(String str) {
        if (this.mData != null && !at.isEmpty(str) && this.gif != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.gif.a(this.gie, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.gif.a(this.gie, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
