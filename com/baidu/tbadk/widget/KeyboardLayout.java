package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean ajc;
    private l ajd;
    private int mHeight;
    private boolean xe;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajc = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajc = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.ajc = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.ajd = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.ajc) {
            this.ajc = true;
            this.mHeight = i4;
            if (this.ajd != null) {
                this.ajd.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.ajc && this.mHeight > i4) {
            this.xe = true;
            if (this.ajd != null) {
                this.ajd.onKeyBoardStateChange(-3);
            }
        }
        if (this.ajc && this.xe && this.mHeight == i4) {
            this.xe = false;
            if (this.ajd != null) {
                this.ajd.onKeyBoardStateChange(-2);
            }
        }
    }
}
