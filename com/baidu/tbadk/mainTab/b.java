package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class b {
    protected d mFragement = createFragmentTabStructure();
    protected FragmentTabIndicator mIndicator;

    public abstract d createFragmentTabStructure();

    public abstract FragmentTabIndicator getTabIndicator(Context context);

    public abstract boolean isAvailable();

    public d getFragmentTabStructure() {
        return this.mFragement;
    }
}
