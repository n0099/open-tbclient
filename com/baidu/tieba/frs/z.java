package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fsH = new z();
    private final SparseArray<String> fsG = new SparseArray<>();

    private z() {
    }

    public static z blA() {
        return fsH;
    }

    public void ru(int i) {
        this.fsG.put(i, "1");
    }

    public boolean rv(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fsG.get(i));
    }
}
