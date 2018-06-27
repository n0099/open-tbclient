package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aXN;
    private a aXO;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aK(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXN = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXN = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aXN = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aXO = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aXN) {
            this.aXN = true;
            this.mHeight = i4;
            if (this.aXO != null) {
                this.aXO.aK(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aXN && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aXO != null) {
                this.aXO.aK(-3);
            }
        }
        if (this.aXN && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aXO != null) {
                this.aXO.aK(-2);
            }
        }
    }
}
