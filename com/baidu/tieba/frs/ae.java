package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ae {
    private static ae hJR = new ae();
    private SparseArray<af> hJQ = new SparseArray<>();

    private ae() {
    }

    public static ae cdv() {
        return hJR;
    }

    public af vc(int i) {
        return this.hJQ.get(i);
    }
}
