package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class af {
    private static final af hro = new af();
    private LongSparseArray<LinkedList<String>> hrn = new LongSparseArray<>();

    private af() {
    }

    public static af bWT() {
        return hro;
    }

    public void ef(long j) {
        LinkedList<String> linkedList = this.hrn.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
