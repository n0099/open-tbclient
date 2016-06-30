package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class dh {
    private static final dh bGV = new dh();
    private LongSparseArray<LinkedList<String>> bGU = new LongSparseArray<>();

    private dh() {
    }

    public static dh WY() {
        return bGV;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bGU.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bGU.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bGU.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aW(long j) {
        LinkedList<String> linkedList = this.bGU.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
