package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean ajf;
    private l ajg;
    private int mHeight;
    private boolean xh;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajf = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajf = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.ajf = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.ajg = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.ajf) {
            this.ajf = true;
            this.mHeight = i4;
            if (this.ajg != null) {
                this.ajg.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.ajf && this.mHeight > i4) {
            this.xh = true;
            if (this.ajg != null) {
                this.ajg.onKeyBoardStateChange(-3);
            }
        }
        if (this.ajf && this.xh && this.mHeight == i4) {
            this.xh = false;
            if (this.ajg != null) {
                this.ajg.onKeyBoardStateChange(-2);
            }
        }
    }
}
