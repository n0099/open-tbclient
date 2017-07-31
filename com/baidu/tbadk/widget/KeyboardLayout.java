package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aNX;
    private a aNY;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aL(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNX = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNX = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aNX = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aNY = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aNX) {
            this.aNX = true;
            this.mHeight = i4;
            if (this.aNY != null) {
                this.aNY.aL(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aNX && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aNY != null) {
                this.aNY.aL(-3);
            }
        }
        if (this.aNX && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aNY != null) {
                this.aNY.aL(-2);
            }
        }
    }
}
