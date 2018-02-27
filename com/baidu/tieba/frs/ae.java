package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ae {
    private static final ae dHj = new ae();
    private LongSparseArray<LinkedList<String>> dHi = new LongSparseArray<>();

    private ae() {
    }

    public static ae awm() {
        return dHj;
    }

    public void bF(long j) {
        LinkedList<String> linkedList = this.dHi.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
