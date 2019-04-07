package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fcC = new aa();
    private LongSparseArray<LinkedList<String>> fcB = new LongSparseArray<>();

    private aa() {
    }

    public static aa ben() {
        return fcC;
    }

    public void cF(long j) {
        LinkedList<String> linkedList = this.fcB.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
