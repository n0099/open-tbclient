package com.baidu.tieba.frs;

import android.support.v4.util.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac {
    private static final ac crZ = new ac();
    private LongSparseArray<LinkedList<String>> crY = new LongSparseArray<>();

    private ac() {
    }

    public static ac ahU() {
        return crZ;
    }

    public void d(long j, String str) {
        LinkedList<String> linkedList = this.crY.get(j);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.crY.put(j, linkedList);
        }
        linkedList.add(str);
    }

    public boolean e(long j, String str) {
        LinkedList<String> linkedList = this.crY.get(j);
        return linkedList != null && linkedList.contains(str);
    }

    public void bi(long j) {
        LinkedList<String> linkedList = this.crY.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
