package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class ai {
    private static final ai hJZ = new ai();
    private LongSparseArray<LinkedList<String>> hJY = new LongSparseArray<>();

    private ai() {
    }

    public static ai cdB() {
        return hJZ;
    }

    public void ev(long j) {
        LinkedList<String> linkedList = this.hJY.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
