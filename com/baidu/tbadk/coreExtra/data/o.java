package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class o {
    private int aCg;
    private int aCh;
    private int aCi;

    public int Ck() {
        return this.aCg == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aCg;
    }

    public void fA(String str) {
        this.aCg = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Cl() {
        return this.aCh;
    }

    public void fB(String str) {
        this.aCh = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Cm() {
        return this.aCi;
    }

    public void fC(String str) {
        this.aCi = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
