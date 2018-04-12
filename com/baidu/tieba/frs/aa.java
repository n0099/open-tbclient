package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class aa {
    private static final aa dah = new aa();
    private LongSparseArray<LinkedList<String>> dag = new LongSparseArray<>();

    private aa() {
    }

    public static aa aqH() {
        return dah;
    }

    public void bC(long j) {
        LinkedList<String> linkedList = this.dag.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
