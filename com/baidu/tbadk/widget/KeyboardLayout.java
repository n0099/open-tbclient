package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean Ii;
    private boolean aBJ;
    private a aBK;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBJ = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBJ = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aBJ = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aBK = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aBJ) {
            this.aBJ = true;
            this.mHeight = i4;
            if (this.aBK != null) {
                this.aBK.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aBJ && this.mHeight > i4) {
            this.Ii = true;
            if (this.aBK != null) {
                this.aBK.onKeyBoardStateChange(-3);
            }
        }
        if (this.aBJ && this.Ii && this.mHeight == i4) {
            this.Ii = false;
            if (this.aBK != null) {
                this.aBK.onKeyBoardStateChange(-2);
            }
        }
    }
}
