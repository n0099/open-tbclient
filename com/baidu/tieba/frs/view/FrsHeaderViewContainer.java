package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
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

    public void addHeaderView(View view2) {
        addView(view2, new LinearLayout.LayoutParams(-1, -2));
    }

    public void addHeaderView(View view2, int i) {
        addView(view2, i, new LinearLayout.LayoutParams(-1, -2));
    }

    public void removeHeaderView(View view2) {
        removeView(view2);
    }

    public int getHeaderViewsCount() {
        return getChildCount();
    }
}
