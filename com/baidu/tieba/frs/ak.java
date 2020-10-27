package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class ak {
    private static final ak iGa = new ak();
    private LongSparseArray<LinkedList<String>> iFZ = new LongSparseArray<>();

    private ak() {
    }

    public static ak cxT() {
        return iGa;
    }

    public void fj(long j) {
        LinkedList<String> linkedList = this.iFZ.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
