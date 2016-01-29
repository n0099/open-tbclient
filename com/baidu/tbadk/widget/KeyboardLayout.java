package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean IN;
    private boolean aEg;
    private a aEh;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aH(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEg = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEg = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aEg = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aEh = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aEg) {
            this.aEg = true;
            this.mHeight = i4;
            if (this.aEh != null) {
                this.aEh.aH(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aEg && this.mHeight > i4) {
            this.IN = true;
            if (this.aEh != null) {
                this.aEh.aH(-3);
            }
        }
        if (this.aEg && this.IN && this.mHeight == i4) {
            this.IN = false;
            if (this.aEh != null) {
                this.aEh.aH(-2);
            }
        }
    }
}
