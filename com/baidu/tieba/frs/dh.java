package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class dh {
    private static final dh bIr = new dh();
    private LongSparseArray<LinkedList<String>> bIq = new LongSparseArray<>();

    private dh() {
    }

    public static dh Xq() {
        return bIr;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bIq.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bIq.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bIq.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aR(long j) {
        LinkedList<String> linkedList = this.bIq.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
