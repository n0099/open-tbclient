package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes7.dex */
public class FrsHeaderViewContainer extends LinearLayout {
    public FrsHeaderViewContainer(Context context) {
        super(context);
        initView();
    }

    public FrsHeaderViewContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FrsHeaderViewContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void initView() {
        setOrientation(1);
    }

    public void addHeaderView(View view) {
        addView(view, new LinearLayout.LayoutParams(-1, -2));
    }

    public void addHeaderView(View view, int i) {
        addView(view, i, new LinearLayout.LayoutParams(-1, -2));
    }

    public void removeHeaderView(View view) {
        removeView(view);
    }

    public int getHeaderViewsCount() {
        return getChildCount();
    }
}
