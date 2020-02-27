package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class ab {
    private static final ab gse = new ab();
    private LongSparseArray<LinkedList<String>> gsd = new LongSparseArray<>();

    private ab() {
    }

    public static ab bFH() {
        return gse;
    }

    public void dv(long j) {
        LinkedList<String> linkedList = this.gsd.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
