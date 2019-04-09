package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int bXl;
    private int bXm;
    private int bXn;

    public int ags() {
        return this.bXl == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.bXl;
    }

    public void nF(String str) {
        this.bXl = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agt() {
        return this.bXm;
    }

    public void nG(String str) {
        this.bXm = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agu() {
        return this.bXn;
    }

    public void nH(String str) {
        this.bXn = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
