package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cDu;
    private a cDv;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDu = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDu = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cDu = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cDv = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cDu) {
            this.cDu = true;
            this.mHeight = i4;
            if (this.cDv != null) {
                this.cDv.aM(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cDu && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cDv != null) {
                this.cDv.aM(-3);
            }
        }
        if (this.cDu && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cDv != null) {
                this.cDv.aM(-2);
            }
        }
    }
}
