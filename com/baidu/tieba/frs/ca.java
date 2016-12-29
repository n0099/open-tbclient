package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ca {
    private static final ca bBE = new ca();
    private LongSparseArray<LinkedList<String>> bBD = new LongSparseArray<>();

    private ca() {
    }

    public static ca XZ() {
        return bBE;
    }

    public void g(long j, String str) {
        LinkedList<String> linkedList = this.bBD.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bBD.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean h(long j, String str) {
        LinkedList<String> linkedList = this.bBD.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aZ(long j) {
        LinkedList<String> linkedList = this.bBD.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
