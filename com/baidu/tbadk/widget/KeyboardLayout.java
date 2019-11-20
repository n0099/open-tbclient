package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cPe;
    private a cPf;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cPe = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPe = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cPe = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cPf = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cPe) {
            this.cPe = true;
            this.mHeight = i4;
            if (this.cPf != null) {
                this.cPf.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cPe && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cPf != null) {
                this.cPf.onKeyBoardStateChange(-3);
            }
        }
        if (this.cPe && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cPf != null) {
                this.cPf.onKeyBoardStateChange(-2);
            }
        }
    }
}
