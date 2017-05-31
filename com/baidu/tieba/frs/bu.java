package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bu {
    private static final bu bWQ = new bu();
    private LongSparseArray<LinkedList<String>> bWP = new LongSparseArray<>();

    private bu() {
    }

    public static bu abf() {
        return bWQ;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bWP.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bWP.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bWP.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aS(long j) {
        LinkedList<String> linkedList = this.bWP.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
