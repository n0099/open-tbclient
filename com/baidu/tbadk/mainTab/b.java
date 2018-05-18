package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c aId = Fv();
    protected TbFragmentTabIndicator aIe;

    public abstract c Fv();

    public abstract TbFragmentTabIndicator aT(Context context);

    public abstract boolean isAvailable();

    public void Fu() {
    }

    public void ck() {
    }

    public c Fw() {
        return this.aId;
    }
}
