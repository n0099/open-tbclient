package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class by {
    private static final by bIY = new by();
    private LongSparseArray<LinkedList<String>> bIX = new LongSparseArray<>();

    private by() {
    }

    public static by Zg() {
        return bIY;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bIX.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bIX.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bIX.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aV(long j) {
        LinkedList<String> linkedList = this.bIX.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
