package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class af {
    private static final af hcp = new af();
    private LongSparseArray<LinkedList<String>> hco = new LongSparseArray<>();

    private af() {
    }

    public static af bQv() {
        return hcp;
    }

    public void ee(long j) {
        LinkedList<String> linkedList = this.hco.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
