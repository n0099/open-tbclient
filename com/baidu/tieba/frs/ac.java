package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ac {
    private static final ac dpA = new ac();
    private LongSparseArray<LinkedList<String>> dpz = new LongSparseArray<>();

    private ac() {
    }

    public static ac avJ() {
        return dpA;
    }

    public void bH(long j) {
        LinkedList<String> linkedList = this.dpz.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
