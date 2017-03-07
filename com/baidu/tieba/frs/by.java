package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class by {
    private static final by bQh = new by();
    private LongSparseArray<LinkedList<String>> bQg = new LongSparseArray<>();

    private by() {
    }

    public static by aaf() {
        return bQh;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bQg.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bQg.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bQg.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aV(long j) {
        LinkedList<String> linkedList = this.bQg.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
