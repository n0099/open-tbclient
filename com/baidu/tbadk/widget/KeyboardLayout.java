package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aJY;
    private a aJZ;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aK(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJY = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJY = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aJY = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aJZ = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aJY) {
            this.aJY = true;
            this.mHeight = i4;
            if (this.aJZ != null) {
                this.aJZ.aK(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aJY && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aJZ != null) {
                this.aJZ.aK(-3);
            }
        }
        if (this.aJY && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aJZ != null) {
                this.aJZ.aK(-2);
            }
        }
    }
}
