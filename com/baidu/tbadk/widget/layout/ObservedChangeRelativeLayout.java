package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ObservedChangeRelativeLayout extends RelativeLayout {
    private e eBM;

    public void setOnSizeChangeListener(e eVar) {
        this.eBM = eVar;
    }

    public e getOnSizeChangeListener() {
        return this.eBM;
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
        if (this.eBM != null) {
            this.eBM.d(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
