package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a.c;
/* loaded from: classes.dex */
public class KPSwitchRootLinearLayout extends LinearLayout {
    private c fpz;

    public KPSwitchRootLinearLayout(Context context) {
        super(context);
        init();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fpz = new c(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.fpz.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }
}
