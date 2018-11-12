package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ac {
    private static final ac dFf = new ac();
    private LongSparseArray<LinkedList<String>> dFe = new LongSparseArray<>();

    private ac() {
    }

    public static ac aAN() {
        return dFf;
    }

    public void bO(long j) {
        LinkedList<String> linkedList = this.dFe.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
