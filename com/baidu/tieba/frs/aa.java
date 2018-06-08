package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class aa {
    private static final aa dkD = new aa();
    private LongSparseArray<LinkedList<String>> dkC = new LongSparseArray<>();

    private aa() {
    }

    public static aa auL() {
        return dkD;
    }

    public void bG(long j) {
        LinkedList<String> linkedList = this.dkC.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
