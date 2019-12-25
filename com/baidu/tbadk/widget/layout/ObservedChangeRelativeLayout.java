package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ObservedChangeRelativeLayout extends RelativeLayout {
    private e dIs;

    public void setOnSizeChangeListener(e eVar) {
        this.dIs = eVar;
    }

    public e getOnSizeChangeListener() {
        return this.dIs;
    }

    public ObservedChangeRelativeLayout(Context context) {
        super(context);
    }

    public ObservedChangeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.dIs != null) {
            this.dIs.d(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
