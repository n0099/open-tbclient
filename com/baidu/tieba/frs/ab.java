package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dmI = new ab();
    private final SparseArray<String> dmH = new SparseArray<>();

    private ab() {
    }

    public static ab ave() {
        return dmI;
    }

    public void kw(int i) {
        this.dmH.put(i, "1");
    }

    public boolean kx(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dmH.get(i));
    }
}
