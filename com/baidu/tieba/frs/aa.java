package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fzZ = new aa();
    private LongSparseArray<LinkedList<String>> fzY = new LongSparseArray<>();

    private aa() {
    }

    public static aa boE() {
        return fzZ;
    }

    public void dl(long j) {
        LinkedList<String> linkedList = this.fzY.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
