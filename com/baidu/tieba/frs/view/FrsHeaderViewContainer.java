package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsHeaderViewContainer extends LinearLayout {
    public FrsHeaderViewContainer(Context context) {
        super(context);
        c();
    }

    public void a(View view) {
        addView(view, new LinearLayout.LayoutParams(-1, -2));
    }

    public void b(View view, int i2) {
        addView(view, i2, new LinearLayout.LayoutParams(-1, -2));
    }

    public void c() {
        setOrientation(1);
    }

    public void d(View view) {
        removeView(view);
    }

    public View getHeadBgContainer() {
        int i2 = 0;
        while (true) {
            View view = null;
            if (i2 >= getChildCount()) {
                return null;
            }
            if (R.id.container == getChildAt(i2).getId()) {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i2);
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    if (R.id.head_top_bg_container == viewGroup.getChildAt(i3).getId()) {
                        view = viewGroup.getChildAt(i3);
                    }
                }
                return view;
            }
            i2++;
        }
    }

    public View getHeaderEmptyView() {
        int i2 = 0;
        while (true) {
            View view = null;
            if (i2 >= getChildCount()) {
                return null;
            }
            if (R.id.container == getChildAt(i2).getId()) {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i2);
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    if (R.id.frs_header_empty_view == viewGroup.getChildAt(i3).getId()) {
                        view = viewGroup.getChildAt(i3);
                    }
                }
                return view;
            }
            i2++;
        }
    }

    public int getHeaderViewsCount() {
        return getChildCount();
    }

    public FrsHeaderViewContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public FrsHeaderViewContainer(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}
