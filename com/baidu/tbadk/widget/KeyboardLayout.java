package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aiC;
    private l aiD;
    private int mHeight;
    private boolean xh;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiC = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiC = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aiC = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.aiD = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aiC) {
            this.aiC = true;
            this.mHeight = i4;
            if (this.aiD != null) {
                this.aiD.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aiC && this.mHeight > i4) {
            this.xh = true;
            if (this.aiD != null) {
                this.aiD.onKeyBoardStateChange(-3);
            }
        }
        if (this.aiC && this.xh && this.mHeight == i4) {
            this.xh = false;
            if (this.aiD != null) {
                this.aiD.onKeyBoardStateChange(-2);
            }
        }
    }
}
