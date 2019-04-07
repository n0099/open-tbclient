package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int bXk;
    private int bXl;
    private int bXm;

    public int ags() {
        return this.bXk == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.bXk;
    }

    public void nF(String str) {
        this.bXk = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agt() {
        return this.bXl;
    }

    public void nG(String str) {
        this.bXl = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agu() {
        return this.bXm;
    }

    public void nH(String str) {
        this.bXm = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
