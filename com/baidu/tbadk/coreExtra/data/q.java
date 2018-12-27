package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int aOg;
    private int aOh;
    private int aOi;

    public int GP() {
        return this.aOg == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aOg;
    }

    public void gF(String str) {
        this.aOg = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int GQ() {
        return this.aOh;
    }

    public void gG(String str) {
        this.aOh = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int GR() {
        return this.aOi;
    }

    public void gH(String str) {
        this.aOi = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
