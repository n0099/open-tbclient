package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class ak {
    private static final ak hXD = new ak();
    private LongSparseArray<LinkedList<String>> hXC = new LongSparseArray<>();

    private ak() {
    }

    public static ak cob() {
        return hXD;
    }

    public void eH(long j) {
        LinkedList<String> linkedList = this.hXC.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
