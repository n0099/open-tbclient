package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class o {
    private int aBv;
    private int aBw;
    private int aBx;

    public int Cd() {
        return this.aBv == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aBv;
    }

    public void fy(String str) {
        this.aBv = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Ce() {
        return this.aBw;
    }

    public void fz(String str) {
        this.aBw = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int Cf() {
        return this.aBx;
    }

    public void fA(String str) {
        this.aBx = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
