package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class ak {
    private static final ak iLX = new ak();
    private LongSparseArray<LinkedList<String>> iLW = new LongSparseArray<>();

    private ak() {
    }

    public static ak cAu() {
        return iLX;
    }

    public void fF(long j) {
        LinkedList<String> linkedList = this.iLW.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
