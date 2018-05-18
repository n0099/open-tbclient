package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class aa {
    private static final aa dbn = new aa();
    private LongSparseArray<LinkedList<String>> dbm = new LongSparseArray<>();

    private aa() {
    }

    public static aa aqG() {
        return dbn;
    }

    public void bC(long j) {
        LinkedList<String> linkedList = this.dbm.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
