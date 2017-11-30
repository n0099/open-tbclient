package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ad {
    private static final ad cKb = new ad();
    private LongSparseArray<LinkedList<String>> cKa = new LongSparseArray<>();

    private ad() {
    }

    public static ad amq() {
        return cKb;
    }

    public void e(long j, String str) {
        LinkedList<String> linkedList = this.cKa.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.cKa.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean f(long j, String str) {
        LinkedList<String> linkedList = this.cKa.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bo(long j) {
        LinkedList<String> linkedList = this.cKa.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
