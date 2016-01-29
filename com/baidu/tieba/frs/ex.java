package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ex {
    private static final ex blQ = new ex();
    private LongSparseArray<LinkedList<String>> blP = new LongSparseArray<>();

    private ex() {
    }

    public static ex QB() {
        return blQ;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.blP.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.blP.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.blP.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aB(long j) {
        LinkedList<String> linkedList = this.blP.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
