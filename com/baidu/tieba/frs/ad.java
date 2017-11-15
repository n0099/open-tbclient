package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ad {
    private static final ad cAX = new ad();
    private LongSparseArray<LinkedList<String>> cAW = new LongSparseArray<>();

    private ad() {
    }

    public static ad aku() {
        return cAX;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.cAW.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.cAW.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.cAW.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bg(long j) {
        LinkedList<String> linkedList = this.cAW.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
