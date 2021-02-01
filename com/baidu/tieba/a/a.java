package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<Integer> gfK;
    private c gfL;
    private HashMap<String, b> mData = new HashMap<>();

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.gfK = arrayList;
        this.gfL = cVar;
    }

    public int aB(String str, int i) {
        if (this.mData == null || au.isEmpty(str) || this.gfK == null || !this.gfK.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.mData.containsKey(str)) {
            Ew(str);
        }
        b bVar = this.mData.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.sW(i);
    }

    public void Ew(String str) {
        if (this.mData != null && !au.isEmpty(str) && this.gfL != null) {
            if (this.mData.containsKey(str)) {
                b bVar = this.mData.get(str);
                this.gfL.a(this.gfK, bVar);
                this.mData.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.gfL.a(this.gfK, bVar2);
            this.mData.put(str, bVar2);
        }
    }
}
