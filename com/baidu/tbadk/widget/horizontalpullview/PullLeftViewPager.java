package com.baidu.tbadk.widget.horizontalpullview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes.dex */
public class PullLeftViewPager extends BdBaseViewPager {
    public PullLeftViewPager(Context context) {
        super(context);
    }

    public PullLeftViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view != this && (view instanceof PullLeftRefreshLayout) && ((PullLeftRefreshLayout) view).bGQ()) {
            return true;
        }
        return super.canScroll(view, z, i, i2, i3);
    }
}
