package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class y {
    private int FrsMaxCache;
    private int FrsPn;
    private int maxCache;

    public int getMaxCache() {
        return this.maxCache == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.maxCache;
    }

    public void setMaxCache(String str) {
        this.maxCache = com.baidu.adp.lib.f.b.toInt(str, 0);
    }

    public int getFrsMaxCache() {
        return this.FrsMaxCache;
    }

    public void setFrsMaxCache(String str) {
        this.FrsMaxCache = com.baidu.adp.lib.f.b.toInt(str, 0);
    }

    public int getFrsPn() {
        return this.FrsPn;
    }

    public void setFrsPn(String str) {
        this.FrsPn = com.baidu.adp.lib.f.b.toInt(str, 0);
    }
}
