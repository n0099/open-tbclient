package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aCW;
    private a aCX;
    private int mHeight;
    private boolean zK;

    /* loaded from: classes.dex */
    public interface a {
        void ax(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCW = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCW = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aCW = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aCX = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aCW) {
            this.aCW = true;
            this.mHeight = i4;
            if (this.aCX != null) {
                this.aCX.ax(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aCW && this.mHeight > i4) {
            this.zK = true;
            if (this.aCX != null) {
                this.aCX.ax(-3);
            }
        }
        if (this.aCW && this.zK && this.mHeight == i4) {
            this.zK = false;
            if (this.aCX != null) {
                this.aCX.ax(-2);
            }
        }
    }
}
