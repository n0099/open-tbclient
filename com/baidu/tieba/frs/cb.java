package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class cb {
    private static final cb bVw = new cb();
    private LongSparseArray<LinkedList<String>> bVv = new LongSparseArray<>();

    private cb() {
    }

    public static cb adG() {
        return bVw;
    }

    public void g(long j, String str) {
        LinkedList<String> linkedList = this.bVv.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.bVv.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean h(long j, String str) {
        LinkedList<String> linkedList = this.bVv.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bm(long j) {
        LinkedList<String> linkedList = this.bVv.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
