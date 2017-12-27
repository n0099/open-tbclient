package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ae {
    private static final ae dzw = new ae();
    private LongSparseArray<LinkedList<String>> dzv = new LongSparseArray<>();

    private ae() {
    }

    public static ae auh() {
        return dzw;
    }

    public void bx(long j) {
        LinkedList<String> linkedList = this.dzv.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
