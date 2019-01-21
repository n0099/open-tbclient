package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int aOJ;
    private int aOK;
    private int aOL;

    public int Hc() {
        return this.aOJ == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aOJ;
    }

    public void gS(String str) {
        this.aOJ = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int Hd() {
        return this.aOK;
    }

    public void gT(String str) {
        this.aOK = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int He() {
        return this.aOL;
    }

    public void gU(String str) {
        this.aOL = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
