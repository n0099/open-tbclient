package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ae {
    private static final ae dHv = new ae();
    private LongSparseArray<LinkedList<String>> dHu = new LongSparseArray<>();

    private ae() {
    }

    public static ae awn() {
        return dHv;
    }

    public void bF(long j) {
        LinkedList<String> linkedList = this.dHu.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
