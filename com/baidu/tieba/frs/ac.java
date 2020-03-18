package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class ac {
    private static final ac gsY = new ac();
    private LongSparseArray<LinkedList<String>> gsX = new LongSparseArray<>();

    private ac() {
    }

    public static ac bFU() {
        return gsY;
    }

    public void dv(long j) {
        LinkedList<String> linkedList = this.gsX.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
