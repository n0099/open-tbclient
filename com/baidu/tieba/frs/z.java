package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fsI = new z();
    private final SparseArray<String> fsH = new SparseArray<>();

    private z() {
    }

    public static z blD() {
        return fsI;
    }

    public void ru(int i) {
        this.fsH.put(i, "1");
    }

    public boolean rv(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fsH.get(i));
    }
}
