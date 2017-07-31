package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac {
    private static final ac clS = new ac();
    private LongSparseArray<LinkedList<String>> clR = new LongSparseArray<>();

    private ac() {
    }

    public static ac agh() {
        return clS;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.clR.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.clR.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.clR.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bi(long j) {
        LinkedList<String> linkedList = this.clR.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
