package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aLB;
    private a aLC;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aJ(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLB = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLB = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aLB = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aLC = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aLB) {
            this.aLB = true;
            this.mHeight = i4;
            if (this.aLC != null) {
                this.aLC.aJ(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aLB && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aLC != null) {
                this.aLC.aJ(-3);
            }
        }
        if (this.aLB && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aLC != null) {
                this.aLC.aJ(-2);
            }
        }
    }
}
