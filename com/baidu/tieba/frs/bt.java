package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bt {
    private static final bt bQZ = new bt();
    private LongSparseArray<LinkedList<String>> bQY = new LongSparseArray<>();

    private bt() {
    }

    public static bt aad() {
        return bQZ;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bQY.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bQY.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bQY.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aP(long j) {
        LinkedList<String> linkedList = this.bQY.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
