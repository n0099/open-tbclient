package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fzf = new z();
    private final SparseArray<String> fze = new SparseArray<>();

    private z() {
    }

    public static z blD() {
        return fzf;
    }

    public void qK(int i) {
        this.fze.put(i, "1");
    }

    public boolean qL(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fze.get(i));
    }
}
