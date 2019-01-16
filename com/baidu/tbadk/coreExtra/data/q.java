package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int aOI;
    private int aOJ;
    private int aOK;

    public int Hc() {
        return this.aOI == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aOI;
    }

    public void gS(String str) {
        this.aOI = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int Hd() {
        return this.aOJ;
    }

    public void gT(String str) {
        this.aOJ = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int He() {
        return this.aOK;
    }

    public void gU(String str) {
        this.aOK = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
