package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ObservedChangeFrameLayout extends FrameLayout {
    private d bqb;

    public ObservedChangeFrameLayout(Context context) {
        super(context);
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(d dVar) {
        this.bqb = dVar;
    }

    public d getOnSizeChangeListener() {
        return this.bqb;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.bqb != null) {
            this.bqb.a(this, i, i2, i3, i4);
        }
    }
}
