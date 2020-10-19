package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aj {
    private static aj itA = new aj();
    private final SparseArray<String> itz = new SparseArray<>();

    private aj() {
    }

    public static aj cuH() {
        return itA;
    }

    public void yA(int i) {
        this.itz.put(i, "1");
    }

    public boolean yB(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.itz.get(i));
    }
}
