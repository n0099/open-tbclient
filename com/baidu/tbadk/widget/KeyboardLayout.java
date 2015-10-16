package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HQ;
    private boolean aAM;
    private a aAN;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAM = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAM = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aAM = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aAN = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aAM) {
            this.aAM = true;
            this.mHeight = i4;
            if (this.aAN != null) {
                this.aAN.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aAM && this.mHeight > i4) {
            this.HQ = true;
            if (this.aAN != null) {
                this.aAN.onKeyBoardStateChange(-3);
            }
        }
        if (this.aAM && this.HQ && this.mHeight == i4) {
            this.HQ = false;
            if (this.aAN != null) {
                this.aAN.onKeyBoardStateChange(-2);
            }
        }
    }
}
