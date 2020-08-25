package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class ak {
    private static final ak hXx = new ak();
    private LongSparseArray<LinkedList<String>> hXw = new LongSparseArray<>();

    private ak() {
    }

    public static ak coa() {
        return hXx;
    }

    public void eH(long j) {
        LinkedList<String> linkedList = this.hXw.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
