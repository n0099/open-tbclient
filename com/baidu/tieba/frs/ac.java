package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ac {
    private static final ac dOs = new ac();
    private LongSparseArray<LinkedList<String>> dOr = new LongSparseArray<>();

    private ac() {
    }

    public static ac aDm() {
        return dOs;
    }

    public void ca(long j) {
        LinkedList<String> linkedList = this.dOr.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
