package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean US;
    private a bkQ;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void bk(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.US = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.US = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.US = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.bkQ = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.US) {
            this.US = true;
            this.mHeight = i4;
            if (this.bkQ != null) {
                this.bkQ.bk(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.US && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.bkQ != null) {
                this.bkQ.bk(-3);
            }
        }
        if (this.US && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.bkQ != null) {
                this.bkQ.bk(-2);
            }
        }
    }
}
