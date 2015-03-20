package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HW;
    private boolean arE;
    private l arF;
    private int mHeight;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arE = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arE = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.arE = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.arF = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.arE) {
            this.arE = true;
            this.mHeight = i4;
            if (this.arF != null) {
                this.arF.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.arE && this.mHeight > i4) {
            this.HW = true;
            if (this.arF != null) {
                this.arF.onKeyBoardStateChange(-3);
            }
        }
        if (this.arE && this.HW && this.mHeight == i4) {
            this.HW = false;
            if (this.arF != null) {
                this.arF.onKeyBoardStateChange(-2);
            }
        }
    }
}
