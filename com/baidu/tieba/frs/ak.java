package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class ak {
    private static final ak itE = new ak();
    private LongSparseArray<LinkedList<String>> itD = new LongSparseArray<>();

    private ak() {
    }

    public static ak cuM() {
        return itE;
    }

    public void fi(long j) {
        LinkedList<String> linkedList = this.itD.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
