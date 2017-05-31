package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aKm;
    private a aKn;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aJ(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKm = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKm = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aKm = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aKn = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aKm) {
            this.aKm = true;
            this.mHeight = i4;
            if (this.aKn != null) {
                this.aKn.aJ(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aKm && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aKn != null) {
                this.aKn.aJ(-3);
            }
        }
        if (this.aKm && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aKn != null) {
                this.aKn.aJ(-2);
            }
        }
    }
}
