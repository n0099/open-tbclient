package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aEB;
    private a aEC;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aK(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEB = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEB = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aEB = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aEC = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aEB) {
            this.aEB = true;
            this.mHeight = i4;
            if (this.aEC != null) {
                this.aEC.aK(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aEB && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aEC != null) {
                this.aEC.aK(-3);
            }
        }
        if (this.aEB && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aEC != null) {
                this.aEC.aK(-2);
            }
        }
    }
}
