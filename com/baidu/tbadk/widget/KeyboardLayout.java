package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean Ca;
    private boolean aFM;
    private a aFN;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aL(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFM = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFM = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aFM = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aFN = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aFM) {
            this.aFM = true;
            this.mHeight = i4;
            if (this.aFN != null) {
                this.aFN.aL(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aFM && this.mHeight > i4) {
            this.Ca = true;
            if (this.aFN != null) {
                this.aFN.aL(-3);
            }
        }
        if (this.aFM && this.Ca && this.mHeight == i4) {
            this.Ca = false;
            if (this.aFN != null) {
                this.aFN.aL(-2);
            }
        }
    }
}
