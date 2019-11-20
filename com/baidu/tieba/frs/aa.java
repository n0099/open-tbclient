package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fyx = new aa();
    private LongSparseArray<LinkedList<String>> fyw = new LongSparseArray<>();

    private aa() {
    }

    public static aa blG() {
        return fyx;
    }

    public void cK(long j) {
        LinkedList<String> linkedList = this.fyw.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
