package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
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

    public View getHeadBgContainer() {
        for (int i = 0; i < getChildCount(); i++) {
            if (R.id.container == getChildAt(i).getId()) {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i);
                View view = null;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (R.id.head_top_bg_container == viewGroup.getChildAt(i2).getId()) {
                        view = viewGroup.getChildAt(i2);
                    }
                }
                return view;
            }
        }
        return null;
    }

    public View getHeaderEmptyView() {
        for (int i = 0; i < getChildCount(); i++) {
            if (R.id.container == getChildAt(i).getId()) {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i);
                View view = null;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (R.id.frs_header_empty_view == viewGroup.getChildAt(i2).getId()) {
                        view = viewGroup.getChildAt(i2);
                    }
                }
                return view;
            }
        }
        return null;
    }
}
