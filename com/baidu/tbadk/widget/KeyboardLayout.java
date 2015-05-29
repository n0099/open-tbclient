package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HO;
    private boolean atq;
    private l atr;
    private int mHeight;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atq = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atq = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.atq = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.atr = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.atq) {
            this.atq = true;
            this.mHeight = i4;
            if (this.atr != null) {
                this.atr.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.atq && this.mHeight > i4) {
            this.HO = true;
            if (this.atr != null) {
                this.atr.onKeyBoardStateChange(-3);
            }
        }
        if (this.atq && this.HO && this.mHeight == i4) {
            this.HO = false;
            if (this.atr != null) {
                this.atr.onKeyBoardStateChange(-2);
            }
        }
    }
}
