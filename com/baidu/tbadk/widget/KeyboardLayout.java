package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aaQ;
    private l aaR;
    private int mHeight;
    private boolean vb;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaQ = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaQ = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aaQ = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.aaR = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aaQ) {
            this.aaQ = true;
            this.mHeight = i4;
            if (this.aaR != null) {
                this.aaR.aj(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aaQ && this.mHeight > i4) {
            this.vb = true;
            if (this.aaR != null) {
                this.aaR.aj(-3);
            }
        }
        if (this.aaQ && this.vb && this.mHeight == i4) {
            this.vb = false;
            if (this.aaR != null) {
                this.aaR.aj(-2);
            }
        }
    }
}
