package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ac {
    private static final ac dDP = new ac();
    private LongSparseArray<LinkedList<String>> dDO = new LongSparseArray<>();

    private ac() {
    }

    public static ac aBq() {
        return dDP;
    }

    public void bS(long j) {
        LinkedList<String> linkedList = this.dDO.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
