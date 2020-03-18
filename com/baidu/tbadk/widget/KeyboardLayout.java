package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private a dHU;
    private boolean mHasInit;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHasInit = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.mHasInit = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.dHU = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = i4;
            if (this.dHU != null) {
                this.dHU.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.mHasInit && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.dHU != null) {
                this.dHU.onKeyBoardStateChange(-3);
            }
        }
        if (this.mHasInit && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.dHU != null) {
                this.dHU.onKeyBoardStateChange(-2);
            }
        }
    }
}
