package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c cJj = avw();
    protected TbFragmentTabIndicator cJk;

    public abstract c avw();

    public abstract TbFragmentTabIndicator cB(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }

    public c avx() {
        return this.cJj;
    }
}
