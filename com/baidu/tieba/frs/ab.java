package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class ab {
    private static final ab gsg = new ab();
    private LongSparseArray<LinkedList<String>> gsf = new LongSparseArray<>();

    private ab() {
    }

    public static ab bFJ() {
        return gsg;
    }

    public void dv(long j) {
        LinkedList<String> linkedList = this.gsf.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
