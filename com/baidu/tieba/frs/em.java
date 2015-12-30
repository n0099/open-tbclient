package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class em {
    private static final em biV = new em();
    private LongSparseArray<LinkedList<String>> biU = new LongSparseArray<>();

    private em() {
    }

    public static em Oz() {
        return biV;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.biU.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.biU.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.biU.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void az(long j) {
        LinkedList<String> linkedList = this.biU.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
