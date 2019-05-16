package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fsQ = new aa();
    private LongSparseArray<LinkedList<String>> fsP = new LongSparseArray<>();

    private aa() {
    }

    public static aa blF() {
        return fsQ;
    }

    public void db(long j) {
        LinkedList<String> linkedList = this.fsP.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
