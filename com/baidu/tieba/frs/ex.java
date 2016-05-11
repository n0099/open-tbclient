package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ex {
    private static final ex bmv = new ex();
    private LongSparseArray<LinkedList<String>> bmu = new LongSparseArray<>();

    private ex() {
    }

    public static ex RE() {
        return bmv;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bmu.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bmu.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bmu.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aG(long j) {
        LinkedList<String> linkedList = this.bmu.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
