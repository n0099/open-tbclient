package com.baidu.tieba.game.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class GameCenterPager extends ViewPager {
    public GameCenterPager(Context context) {
        this(context, null);
    }

    public GameCenterPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.view.ViewPager
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view == this || !(view instanceof ViewPager)) {
            return super.canScroll(view, z, i, i2, i3);
        }
        return true;
    }
}
