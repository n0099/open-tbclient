package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ac {
    private static final ac dpC = new ac();
    private LongSparseArray<LinkedList<String>> dpB = new LongSparseArray<>();

    private ac() {
    }

    public static ac avK() {
        return dpC;
    }

    public void bH(long j) {
        LinkedList<String> linkedList = this.dpB.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
