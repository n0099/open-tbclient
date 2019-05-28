package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fsR = new aa();
    private LongSparseArray<LinkedList<String>> fsQ = new LongSparseArray<>();

    private aa() {
    }

    public static aa blI() {
        return fsR;
    }

    public void db(long j) {
        LinkedList<String> linkedList = this.fsQ.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
