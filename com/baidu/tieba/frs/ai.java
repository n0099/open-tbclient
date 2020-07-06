package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class ai {
    private static final ai hEb = new ai();
    private LongSparseArray<LinkedList<String>> hEa = new LongSparseArray<>();

    private ai() {
    }

    public static ai cae() {
        return hEb;
    }

    public void ei(long j) {
        LinkedList<String> linkedList = this.hEa.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
