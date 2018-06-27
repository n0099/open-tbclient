package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class o {
    private int aCp;
    private int aCq;
    private int aCr;

    public int Cv() {
        return this.aCp == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aCp;
    }

    public void fC(String str) {
        this.aCp = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Cw() {
        return this.aCq;
    }

    public void fD(String str) {
        this.aCq = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Cx() {
        return this.aCr;
    }

    public void fE(String str) {
        this.aCr = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
