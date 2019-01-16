package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ac {
    private static final ac dPb = new ac();
    private LongSparseArray<LinkedList<String>> dPa = new LongSparseArray<>();

    private ac() {
    }

    public static ac aDJ() {
        return dPb;
    }

    public void ca(long j) {
        LinkedList<String> linkedList = this.dPa.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
