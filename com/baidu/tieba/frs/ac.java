package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ac {
    private static final ac dLE = new ac();
    private LongSparseArray<LinkedList<String>> dLD = new LongSparseArray<>();

    private ac() {
    }

    public static ac aCx() {
        return dLE;
    }

    public void bV(long j) {
        LinkedList<String> linkedList = this.dLD.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
