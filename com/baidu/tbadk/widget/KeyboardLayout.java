package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cvj;
    private a cvk;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aT(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvj = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvj = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cvj = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cvk = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cvj) {
            this.cvj = true;
            this.mHeight = i4;
            if (this.cvk != null) {
                this.cvk.aT(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cvj && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cvk != null) {
                this.cvk.aT(-3);
            }
        }
        if (this.cvj && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cvk != null) {
                this.cvk.aT(-2);
            }
        }
    }
}
