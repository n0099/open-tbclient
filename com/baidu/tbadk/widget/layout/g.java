package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class g extends RelativeLayout {
    private i aHz;

    public void setOnSizeChangeListener(i iVar) {
        this.aHz = iVar;
    }

    public i getOnSizeChangeListener() {
        return this.aHz;
    }

    public g(Context context) {
        super(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aHz != null) {
            this.aHz.a(this, i, i2, i3, i4);
        }
    }
}
