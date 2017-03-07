package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c aDB = EF();
    protected FragmentTabIndicator aDC;

    public abstract c EF();

    public abstract FragmentTabIndicator aN(Context context);

    public abstract boolean isAvailable();

    public void EE() {
    }

    public void cC() {
    }

    public c EG() {
        return this.aDB;
    }
}
