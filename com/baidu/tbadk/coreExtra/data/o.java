package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class o {
    private int aCj;
    private int aCk;
    private int aCl;

    public int Cn() {
        return this.aCj == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aCj;
    }

    public void fA(String str) {
        this.aCj = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Co() {
        return this.aCk;
    }

    public void fB(String str) {
        this.aCk = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Cp() {
        return this.aCl;
    }

    public void fC(String str) {
        this.aCl = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
