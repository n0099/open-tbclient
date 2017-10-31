package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ad {
    private static final ad cAE = new ad();
    private LongSparseArray<LinkedList<String>> cAD = new LongSparseArray<>();

    private ad() {
    }

    public static ad akg() {
        return cAE;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.cAD.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.cAD.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.cAD.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bg(long j) {
        LinkedList<String> linkedList = this.cAD.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
