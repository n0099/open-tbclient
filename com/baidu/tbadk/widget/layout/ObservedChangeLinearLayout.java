package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ObservedChangeLinearLayout extends LinearLayout {
    private d blM;

    public void setOnSizeChangeListener(d dVar) {
        this.blM = dVar;
    }

    public d getOnSizeChangeListener() {
        return this.blM;
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
        if (this.blM != null) {
            this.blM.a(this, i, i2, i3, i4);
        }
    }
}
