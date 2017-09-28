package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ad {
    private static final ad ctt = new ad();
    private LongSparseArray<LinkedList<String>> cts = new LongSparseArray<>();

    private ad() {
    }

    public static ad aid() {
        return ctt;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.cts.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.cts.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.cts.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bf(long j) {
        LinkedList<String> linkedList = this.cts.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
