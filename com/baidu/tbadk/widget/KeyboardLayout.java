package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cFL;
    private a cFM;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFL = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cFL = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cFL = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cFM = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cFL) {
            this.cFL = true;
            this.mHeight = i4;
            if (this.cFM != null) {
                this.cFM.aM(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cFL && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cFM != null) {
                this.cFM.aM(-3);
            }
        }
        if (this.cFL && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cFM != null) {
                this.cFM.aM(-2);
            }
        }
    }
}
