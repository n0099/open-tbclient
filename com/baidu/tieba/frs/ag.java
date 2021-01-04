package com.baidu.tieba.frs;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ag {
    private static final ag jjQ = new ag();
    private LongSparseArray<LinkedList<String>> jjP = new LongSparseArray<>();

    private ag() {
    }

    public static ag cHj() {
        return jjQ;
    }

    public void gm(long j) {
        LinkedList<String> linkedList = this.jjP.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
