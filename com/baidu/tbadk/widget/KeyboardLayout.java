package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean Iy;
    private boolean aDq;
    private a aDr;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDq = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDq = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aDq = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aDr = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aDq) {
            this.aDq = true;
            this.mHeight = i4;
            if (this.aDr != null) {
                this.aDr.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aDq && this.mHeight > i4) {
            this.Iy = true;
            if (this.aDr != null) {
                this.aDr.onKeyBoardStateChange(-3);
            }
        }
        if (this.aDq && this.Iy && this.mHeight == i4) {
            this.Iy = false;
            if (this.aDr != null) {
                this.aDr.onKeyBoardStateChange(-2);
            }
        }
    }
}
