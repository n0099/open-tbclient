package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class aj {
    private static final aj iXD = new aj();
    private LongSparseArray<LinkedList<String>> iXC = new LongSparseArray<>();

    private aj() {
    }

    public static aj cEo() {
        return iXD;
    }

    public void gm(long j) {
        LinkedList<String> linkedList = this.iXC.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
