package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HY;
    private boolean arM;
    private l arN;
    private int mHeight;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arM = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arM = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.arM = false;
    }

    public void setOnkbdStateListener(l lVar) {
        this.arN = lVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.arM) {
            this.arM = true;
            this.mHeight = i4;
            if (this.arN != null) {
                this.arN.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.arM && this.mHeight > i4) {
            this.HY = true;
            if (this.arN != null) {
                this.arN.onKeyBoardStateChange(-3);
            }
        }
        if (this.arM && this.HY && this.mHeight == i4) {
            this.HY = false;
            if (this.arN != null) {
                this.arN.onKeyBoardStateChange(-2);
            }
        }
    }
}
