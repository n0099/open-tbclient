package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class af {
    private static final af hrd = new af();
    private LongSparseArray<LinkedList<String>> hrc = new LongSparseArray<>();

    private af() {
    }

    public static af bWR() {
        return hrd;
    }

    public void ef(long j) {
        LinkedList<String> linkedList = this.hrc.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
