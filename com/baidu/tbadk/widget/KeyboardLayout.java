package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean UI;
    private a bkc;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void bk(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UI = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UI = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.UI = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.bkc = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.UI) {
            this.UI = true;
            this.mHeight = i4;
            if (this.bkc != null) {
                this.bkc.bk(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.UI && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.bkc != null) {
                this.bkc.bk(-3);
            }
        }
        if (this.UI && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.bkc != null) {
                this.bkc.bk(-2);
            }
        }
    }
}
