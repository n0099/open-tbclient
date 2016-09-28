package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class dd {
    private static final dd bTq = new dd();
    private LongSparseArray<LinkedList<String>> bTp = new LongSparseArray<>();

    private dd() {
    }

    public static dd acA() {
        return bTq;
    }

    public void g(long j, String str) {
        LinkedList<String> linkedList = this.bTp.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bTp.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean h(long j, String str) {
        LinkedList<String> linkedList = this.bTp.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bn(long j) {
        LinkedList<String> linkedList = this.bTp.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
