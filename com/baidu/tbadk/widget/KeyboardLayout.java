package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private a aKA;
    private boolean aKz;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aI(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKz = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKz = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aKz = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aKA = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aKz) {
            this.aKz = true;
            this.mHeight = i4;
            if (this.aKA != null) {
                this.aKA.aI(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aKz && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aKA != null) {
                this.aKA.aI(-3);
            }
        }
        if (this.aKz && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aKA != null) {
                this.aKA.aI(-2);
            }
        }
    }
}
