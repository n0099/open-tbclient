package com.baidu.tieba.frs;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ag {
    private static final ag jfi = new ag();
    private LongSparseArray<LinkedList<String>> jfh = new LongSparseArray<>();

    private ag() {
    }

    public static ag cDs() {
        return jfi;
    }

    public void gm(long j) {
        LinkedList<String> linkedList = this.jfh.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
