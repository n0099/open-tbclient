package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ac {
    private static final ac dmK = new ac();
    private LongSparseArray<LinkedList<String>> dmJ = new LongSparseArray<>();

    private ac() {
    }

    public static ac avf() {
        return dmK;
    }

    public void bC(long j) {
        LinkedList<String> linkedList = this.dmJ.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
