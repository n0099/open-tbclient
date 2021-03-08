package com.baidu.tieba.frs;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ag {
    private static final ag jmN = new ag();
    private LongSparseArray<LinkedList<String>> jmM = new LongSparseArray<>();

    private ag() {
    }

    public static ag cER() {
        return jmN;
    }

    public void gr(long j) {
        LinkedList<String> linkedList = this.jmM.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
