package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ac {
    private static final ac dPc = new ac();
    private LongSparseArray<LinkedList<String>> dPb = new LongSparseArray<>();

    private ac() {
    }

    public static ac aDJ() {
        return dPc;
    }

    public void ca(long j) {
        LinkedList<String> linkedList = this.dPb.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
