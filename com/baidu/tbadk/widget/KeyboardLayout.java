package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean bCE;
    private a bCF;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCE = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCE = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.bCE = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.bCF = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.bCE) {
            this.bCE = true;
            this.mHeight = i4;
            if (this.bCF != null) {
                this.bCF.dH(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.bCE && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.bCF != null) {
                this.bCF.dH(-3);
            }
        }
        if (this.bCE && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.bCF != null) {
                this.bCF.dH(-2);
            }
        }
    }
}
