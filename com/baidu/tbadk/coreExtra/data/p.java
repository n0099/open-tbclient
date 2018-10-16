package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class p {
    private int aJP;
    private int aJQ;
    private int aJR;

    public int Fy() {
        return this.aJP == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aJP;
    }

    public void gk(String str) {
        this.aJP = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int Fz() {
        return this.aJQ;
    }

    public void gl(String str) {
        this.aJQ = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int FA() {
        return this.aJR;
    }

    public void gm(String str) {
        this.aJR = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
