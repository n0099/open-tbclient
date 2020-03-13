package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class ab {
    private static final ab gst = new ab();
    private LongSparseArray<LinkedList<String>> gss = new LongSparseArray<>();

    private ab() {
    }

    public static ab bFK() {
        return gst;
    }

    public void dv(long j) {
        LinkedList<String> linkedList = this.gss.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
