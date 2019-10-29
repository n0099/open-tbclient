package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cPV;
    private a cPW;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cPV = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPV = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cPV = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cPW = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cPV) {
            this.cPV = true;
            this.mHeight = i4;
            if (this.cPW != null) {
                this.cPW.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cPV && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cPW != null) {
                this.cPW.onKeyBoardStateChange(-3);
            }
        }
        if (this.cPV && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cPW != null) {
                this.cPW.onKeyBoardStateChange(-2);
            }
        }
    }
}
