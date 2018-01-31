package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ae {
    private static final ae dEs = new ae();
    private LongSparseArray<LinkedList<String>> dEr = new LongSparseArray<>();

    private ae() {
    }

    public static ae avp() {
        return dEs;
    }

    public void bE(long j) {
        LinkedList<String> linkedList = this.dEr.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
