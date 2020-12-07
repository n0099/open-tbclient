package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class aj {
    private static final aj iXB = new aj();
    private LongSparseArray<LinkedList<String>> iXA = new LongSparseArray<>();

    private aj() {
    }

    public static aj cEn() {
        return iXB;
    }

    public void gm(long j) {
        LinkedList<String> linkedList = this.iXA.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
