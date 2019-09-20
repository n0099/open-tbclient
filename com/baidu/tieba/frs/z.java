package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fzQ = new z();
    private final SparseArray<String> fzP = new SparseArray<>();

    private z() {
    }

    public static z boz() {
        return fzQ;
    }

    public void rR(int i) {
        this.fzP.put(i, "1");
    }

    public boolean rS(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fzP.get(i));
    }
}
