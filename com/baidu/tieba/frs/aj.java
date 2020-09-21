package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aj {
    private static aj ieD = new aj();
    private final SparseArray<String> ieC = new SparseArray<>();

    private aj() {
    }

    public static aj crj() {
        return ieD;
    }

    public void xU(int i) {
        this.ieC.put(i, "1");
    }

    public boolean xV(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.ieC.get(i));
    }
}
