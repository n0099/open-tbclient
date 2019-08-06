package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class aa {
    private static final aa fym = new aa();
    private LongSparseArray<LinkedList<String>> fyl = new LongSparseArray<>();

    private aa() {
    }

    public static aa bnT() {
        return fym;
    }

    public void di(long j) {
        LinkedList<String> linkedList = this.fyl.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
