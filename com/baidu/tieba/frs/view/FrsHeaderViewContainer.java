package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
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
        View view = null;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            } else if (R.id.container != getChildAt(i).getId()) {
                i++;
            } else {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i);
                int i2 = 0;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = R.id.head_top_bg_container == viewGroup.getChildAt(i2).getId() ? viewGroup.getChildAt(i2) : view;
                    i2++;
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View getHeaderEmptyView() {
        View view = null;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            } else if (R.id.container != getChildAt(i).getId()) {
                i++;
            } else {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i);
                int i2 = 0;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = R.id.frs_header_empty_view == viewGroup.getChildAt(i2).getId() ? viewGroup.getChildAt(i2) : view;
                    i2++;
                    view = childAt;
                }
            }
        }
        return view;
    }
}
