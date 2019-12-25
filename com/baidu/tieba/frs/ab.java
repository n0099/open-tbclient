package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ab {
    private static final ab gmU = new ab();
    private LongSparseArray<LinkedList<String>> gmT = new LongSparseArray<>();

    private ab() {
    }

    public static ab bDc() {
        return gmU;
    }

    public void dq(long j) {
        LinkedList<String> linkedList = this.gmT.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
