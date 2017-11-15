package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aNT;
    private a aNU;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNT = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNT = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aNT = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aNU = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aNT) {
            this.aNT = true;
            this.mHeight = i4;
            if (this.aNU != null) {
                this.aNU.aM(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aNT && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aNU != null) {
                this.aNU.aM(-3);
            }
        }
        if (this.aNT && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aNU != null) {
                this.aNU.aM(-2);
            }
        }
    }
}
