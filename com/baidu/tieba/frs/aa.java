package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fcQ = new aa();
    private LongSparseArray<LinkedList<String>> fcP = new LongSparseArray<>();

    private aa() {
    }

    public static aa bep() {
        return fcQ;
    }

    public void cF(long j) {
        LinkedList<String> linkedList = this.fcP.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
