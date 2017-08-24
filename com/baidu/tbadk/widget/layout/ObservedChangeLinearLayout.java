package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ObservedChangeLinearLayout extends LinearLayout {
    private e aPw;

    public void setOnSizeChangeListener(e eVar) {
        this.aPw = eVar;
    }

    public e getOnSizeChangeListener() {
        return this.aPw;
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
        if (this.aPw != null) {
            this.aPw.a(this, i, i2, i3, i4);
        }
    }
}
