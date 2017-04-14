package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ca {
    private static final ca bPW = new ca();
    private LongSparseArray<LinkedList<String>> bPV = new LongSparseArray<>();

    private ca() {
    }

    public static ca aaD() {
        return bPW;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bPV.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bPV.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bPV.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aV(long j) {
        LinkedList<String> linkedList = this.bPV.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
