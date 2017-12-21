package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aOA;
    private a aOB;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aL(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOA = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOA = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aOA = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aOB = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aOA) {
            this.aOA = true;
            this.mHeight = i4;
            if (this.aOB != null) {
                this.aOB.aL(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aOA && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aOB != null) {
                this.aOB.aL(-3);
            }
        }
        if (this.aOA && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aOB != null) {
                this.aOB.aL(-2);
            }
        }
    }
}
