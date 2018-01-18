package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean bCw;
    private a bCx;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCw = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCw = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.bCw = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.bCx = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.bCw) {
            this.bCw = true;
            this.mHeight = i4;
            if (this.bCx != null) {
                this.bCx.dH(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.bCw && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.bCx != null) {
                this.bCx.dH(-3);
            }
        }
        if (this.bCw && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.bCx != null) {
                this.bCx.dH(-2);
            }
        }
    }
}
