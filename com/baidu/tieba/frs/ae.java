package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ae {
    private static final ae dHo = new ae();
    private LongSparseArray<LinkedList<String>> dHn = new LongSparseArray<>();

    private ae() {
    }

    public static ae awo() {
        return dHo;
    }

    public void bF(long j) {
        LinkedList<String> linkedList = this.dHn.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
