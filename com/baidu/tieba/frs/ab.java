package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dpy = new ab();
    private final SparseArray<String> dpx = new SparseArray<>();

    private ab() {
    }

    public static ab avI() {
        return dpy;
    }

    public void kG(int i) {
        this.dpx.put(i, "1");
    }

    public boolean kH(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dpx.get(i));
    }
}
