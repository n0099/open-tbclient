package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class aa {
    private static final aa dae = new aa();
    private LongSparseArray<LinkedList<String>> dad = new LongSparseArray<>();

    private aa() {
    }

    public static aa aqH() {
        return dae;
    }

    public void bC(long j) {
        LinkedList<String> linkedList = this.dad.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
