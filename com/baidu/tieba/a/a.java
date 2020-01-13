package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<Integer> dTt;
    private c dTu;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.dTt = arrayList;
        this.dTu = cVar;
    }

    public int ak(String str, int i) {
        if (this.mData == null || aq.isEmpty(str) || this.dTt == null || !this.dTt.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            ws(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.nL(i);
    }

    public void ws(String str) {
        if (this.mData != null && !aq.isEmpty(str) && this.dTu != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.dTu.a(this.dTt, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.dTu.a(this.dTt, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
