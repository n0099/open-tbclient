package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int aKF;
    private int aKG;
    private int aKH;

    public int FK() {
        return this.aKF == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aKF;
    }

    public void gl(String str) {
        this.aKF = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int FL() {
        return this.aKG;
    }

    public void gm(String str) {
        this.aKG = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int FM() {
        return this.aKH;
    }

    public void gn(String str) {
        this.aKH = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
