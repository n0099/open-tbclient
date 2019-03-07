package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int bXh;
    private int bXi;
    private int bXj;

    public int agv() {
        return this.bXh == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.bXh;
    }

    public void nE(String str) {
        this.bXh = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agw() {
        return this.bXi;
    }

    public void nF(String str) {
        this.bXi = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int agx() {
        return this.bXj;
    }

    public void nG(String str) {
        this.bXj = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
