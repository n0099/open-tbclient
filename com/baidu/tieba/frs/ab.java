package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab cmC = new ab();
    private final SparseArray<String> cmB = new SparseArray<>();

    private ab() {
    }

    public static ab agB() {
        return cmC;
    }

    public void iN(int i) {
        this.cmB.put(i, "1");
    }

    public boolean iO(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cmB.get(i));
    }
}
