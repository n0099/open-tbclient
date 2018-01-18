package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ae {
    private static final ae dDX = new ae();
    private LongSparseArray<LinkedList<String>> dDW = new LongSparseArray<>();

    private ae() {
    }

    public static ae avk() {
        return dDX;
    }

    public void bC(long j) {
        LinkedList<String> linkedList = this.dDW.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
