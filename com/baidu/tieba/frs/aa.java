package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fzo = new aa();
    private LongSparseArray<LinkedList<String>> fzn = new LongSparseArray<>();

    private aa() {
    }

    public static aa blI() {
        return fzo;
    }

    public void cL(long j) {
        LinkedList<String> linkedList = this.fzn.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
