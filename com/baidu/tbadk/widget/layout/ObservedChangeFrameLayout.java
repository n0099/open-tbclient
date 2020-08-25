package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class ObservedChangeFrameLayout extends FrameLayout {
    private e fcI;

    public ObservedChangeFrameLayout(Context context) {
        super(context);
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(e eVar) {
        this.fcI = eVar;
    }

    public e getOnSizeChangeListener() {
        return this.fcI;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fcI != null) {
            this.fcI.d(this, i, i2, i3, i4);
        }
    }
}
