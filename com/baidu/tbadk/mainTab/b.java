package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected c mFragement = createFragmentTabStructure();
    protected FragmentTabIndicator mIndicator;

    public abstract c createFragmentTabStructure();

    public abstract FragmentTabIndicator getTabIndicator(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }

    public c getFragmentTabStructure() {
        return this.mFragement;
    }
}
