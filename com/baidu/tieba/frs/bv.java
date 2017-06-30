package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bv {
    private static final bv ceY = new bv();
    private LongSparseArray<LinkedList<String>> ceX = new LongSparseArray<>();

    private bv() {
    }

    public static bv aeW() {
        return ceY;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.ceX.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.ceX.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.ceX.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bg(long j) {
        LinkedList<String> linkedList = this.ceX.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
