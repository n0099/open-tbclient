package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean bbm;
    private a bbn;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aV(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbm = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbm = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.bbm = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.bbn = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.bbm) {
            this.bbm = true;
            this.mHeight = i4;
            if (this.bbn != null) {
                this.bbn.aV(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.bbm && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.bbn != null) {
                this.bbn.aV(-3);
            }
        }
        if (this.bbm && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.bbn != null) {
                this.bbn.aV(-2);
            }
        }
    }
}
