package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c cKa = avy();
    protected TbFragmentTabIndicator cKb;

    public abstract c avy();

    public abstract TbFragmentTabIndicator cB(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }

    public c avz() {
        return this.cKa;
    }
}
