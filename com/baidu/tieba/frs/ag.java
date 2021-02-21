package com.baidu.tieba.frs;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ag {
    private static final ag jld = new ag();
    private LongSparseArray<LinkedList<String>> jlc = new LongSparseArray<>();

    private ag() {
    }

    public static ag cEL() {
        return jld;
    }

    public void gr(long j) {
        LinkedList<String> linkedList = this.jlc.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
