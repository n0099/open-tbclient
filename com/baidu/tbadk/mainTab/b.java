package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c dwT = aNe();
    protected TbFragmentTabIndicator dwU;

    public abstract c aNe();

    public abstract TbFragmentTabIndicator dW(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }

    public c aNf() {
        return this.dwT;
    }
}
