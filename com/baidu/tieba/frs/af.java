package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class af {
    private static final af hcj = new af();
    private LongSparseArray<LinkedList<String>> hci = new LongSparseArray<>();

    private af() {
    }

    public static af bQw() {
        return hcj;
    }

    public void ee(long j) {
        LinkedList<String> linkedList = this.hci.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
