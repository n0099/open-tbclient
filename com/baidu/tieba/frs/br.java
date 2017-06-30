package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class br {
    private static br ceS = new br();
    private SparseArray<bs> ceR = new SparseArray<>();

    private br() {
    }

    public static br aeU() {
        return ceS;
    }

    public void a(int i, bs bsVar) {
        this.ceR.put(i, bsVar);
    }

    public bs iA(int i) {
        return this.ceR.get(i);
    }
}
