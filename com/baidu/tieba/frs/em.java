package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class em {
    private static final em bfb = new em();
    private LongSparseArray<LinkedList<String>> bfa = new LongSparseArray<>();

    private em() {
    }

    public static em Og() {
        return bfb;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.bfa.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bfa.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.bfa.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void ay(long j) {
        LinkedList<String> linkedList = this.bfa.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
