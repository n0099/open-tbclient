package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean bEv;
    private a bEw;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEv = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEv = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.bEv = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.bEw = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.bEv) {
            this.bEv = true;
            this.mHeight = i4;
            if (this.bEw != null) {
                this.bEw.dH(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.bEv && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.bEw != null) {
                this.bEw.dH(-3);
            }
        }
        if (this.bEv && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.bEw != null) {
                this.bEw.dH(-2);
            }
        }
    }
}
