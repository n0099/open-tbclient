package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class fg {
    private static final fg brh = new fg();
    private LongSparseArray<LinkedList<String>> brg = new LongSparseArray<>();

    private fg() {
    }

    public static fg Sv() {
        return brh;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.brg.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.brg.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.brg.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void aG(long j) {
        LinkedList<String> linkedList = this.brg.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
