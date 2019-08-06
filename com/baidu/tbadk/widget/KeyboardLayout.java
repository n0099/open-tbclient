package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cEV;
    private a cEW;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cEV = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEV = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cEV = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cEW = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cEV) {
            this.cEV = true;
            this.mHeight = i4;
            if (this.cEW != null) {
                this.cEW.aM(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cEV && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cEW != null) {
                this.cEW.aM(-3);
            }
        }
        if (this.cEV && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cEW != null) {
                this.cEW.aM(-2);
            }
        }
    }
}
