package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int bXi;
    private int bXj;
    private int bXk;

    public int agv() {
        return this.bXi == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.bXi;
    }

    public void nE(String str) {
        this.bXi = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agw() {
        return this.bXj;
    }

    public void nF(String str) {
        this.bXj = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agx() {
        return this.bXk;
    }

    public void nG(String str) {
        this.bXk = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
