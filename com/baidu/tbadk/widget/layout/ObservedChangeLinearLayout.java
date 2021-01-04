package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ObservedChangeLinearLayout extends LinearLayout {
    private e fWY;

    public void setOnSizeChangeListener(e eVar) {
        this.fWY = eVar;
    }

    public e getOnSizeChangeListener() {
        return this.fWY;
    }

    public ObservedChangeLinearLayout(Context context) {
        super(context);
    }

    public ObservedChangeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fWY != null) {
            this.fWY.f(this, i, i2, i3, i4);
        }
    }
}
