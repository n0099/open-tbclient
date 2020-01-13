package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c dxb = aNx();
    protected TbFragmentTabIndicator dxc;

    public abstract c aNx();

    public abstract TbFragmentTabIndicator dW(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }

    public c aNy() {
        return this.dxb;
    }
}
