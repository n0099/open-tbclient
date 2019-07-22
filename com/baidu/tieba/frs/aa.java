package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fxN = new aa();
    private LongSparseArray<LinkedList<String>> fxM = new LongSparseArray<>();

    private aa() {
    }

    public static aa bnJ() {
        return fxN;
    }

    public void di(long j) {
        LinkedList<String> linkedList = this.fxM.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
