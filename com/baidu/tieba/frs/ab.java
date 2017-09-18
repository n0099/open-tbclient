package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab csP = new ab();
    private final SparseArray<String> csO = new SparseArray<>();

    private ab() {
    }

    public static ab aie() {
        return csP;
    }

    public void jb(int i) {
        this.csO.put(i, "1");
    }

    public boolean jc(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.csO.get(i));
    }
}
