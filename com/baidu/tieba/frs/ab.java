package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class ab {
    private static final ab gqd = new ab();
    private LongSparseArray<LinkedList<String>> gqc = new LongSparseArray<>();

    private ab() {
    }

    public static ab bEe() {
        return gqd;
    }

    public void dv(long j) {
        LinkedList<String> linkedList = this.gqc.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
