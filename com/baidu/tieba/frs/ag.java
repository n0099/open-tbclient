package com.baidu.tieba.frs;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ag {
    private static final ag jkP = new ag();
    private LongSparseArray<LinkedList<String>> jkO = new LongSparseArray<>();

    private ag() {
    }

    public static ag cEE() {
        return jkP;
    }

    public void gr(long j) {
        LinkedList<String> linkedList = this.jkO.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
