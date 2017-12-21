package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ae {
    private static final ae cKp = new ae();
    private LongSparseArray<LinkedList<String>> cKo = new LongSparseArray<>();

    private ae() {
    }

    public static ae amz() {
        return cKp;
    }

    public void e(long j, String str) {
        LinkedList<String> linkedList = this.cKo.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.cKo.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean f(long j, String str) {
        LinkedList<String> linkedList = this.cKo.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bo(long j) {
        LinkedList<String> linkedList = this.cKo.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
