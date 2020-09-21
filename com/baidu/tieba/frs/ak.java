package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class ak {
    private static final ak ieH = new ak();
    private LongSparseArray<LinkedList<String>> ieG = new LongSparseArray<>();

    private ak() {
    }

    public static ak cro() {
        return ieH;
    }

    public void eR(long j) {
        LinkedList<String> linkedList = this.ieG.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
