package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class ak {
    private static final ak iMK = new ak();
    private LongSparseArray<LinkedList<String>> iMJ = new LongSparseArray<>();

    private ak() {
    }

    public static ak czX() {
        return iMK;
    }

    public void fI(long j) {
        LinkedList<String> linkedList = this.iMJ.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
