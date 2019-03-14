package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cvh;
    private a cvi;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aU(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvh = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvh = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cvh = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cvi = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cvh) {
            this.cvh = true;
            this.mHeight = i4;
            if (this.cvi != null) {
                this.cvi.aU(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cvh && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cvi != null) {
                this.cvi.aU(-3);
            }
        }
        if (this.cvh && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cvi != null) {
                this.cvi.aU(-2);
            }
        }
    }
}
