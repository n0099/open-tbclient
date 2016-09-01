package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class dd {
    private static final dd bTx = new dd();
    private LongSparseArray<LinkedList<String>> bTw = new LongSparseArray<>();

    private dd() {
    }

    public static dd acn() {
        return bTx;
    }

    public void g(long j, String str) {
        LinkedList<String> linkedList = this.bTw.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bTw.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean h(long j, String str) {
        LinkedList<String> linkedList = this.bTw.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bn(long j) {
        LinkedList<String> linkedList = this.bTw.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
