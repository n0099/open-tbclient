package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ac {
    private static final ac dvO = new ac();
    private LongSparseArray<LinkedList<String>> dvN = new LongSparseArray<>();

    private ac() {
    }

    public static ac axU() {
        return dvO;
    }

    public void bL(long j) {
        LinkedList<String> linkedList = this.dvN.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
