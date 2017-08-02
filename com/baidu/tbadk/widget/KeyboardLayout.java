package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aMJ;
    private a aMK;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aJ(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMJ = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMJ = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aMJ = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aMK = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aMJ) {
            this.aMJ = true;
            this.mHeight = i4;
            if (this.aMK != null) {
                this.aMK.aJ(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aMJ && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aMK != null) {
                this.aMK.aJ(-3);
            }
        }
        if (this.aMJ && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aMK != null) {
                this.aMK.aJ(-2);
            }
        }
    }
}
