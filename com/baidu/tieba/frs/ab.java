package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab cmD = new ab();
    private final SparseArray<String> cmC = new SparseArray<>();

    private ab() {
    }

    public static ab agv() {
        return cmD;
    }

    public void iN(int i) {
        this.cmC.put(i, "1");
    }

    public boolean iO(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cmC.get(i));
    }
}
