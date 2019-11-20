package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fyo = new z();
    private final SparseArray<String> fyn = new SparseArray<>();

    private z() {
    }

    public static z blB() {
        return fyo;
    }

    public void qJ(int i) {
        this.fyn.put(i, "1");
    }

    public boolean qK(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fyn.get(i));
    }
}
