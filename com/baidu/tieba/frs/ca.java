package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ca {
    private static final ca bSn = new ca();
    private LongSparseArray<LinkedList<String>> bSm = new LongSparseArray<>();

    private ca() {
    }

    public static ca abE() {
        return bSn;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bSm.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bSm.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bSm.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aV(long j) {
        LinkedList<String> linkedList = this.bSm.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
