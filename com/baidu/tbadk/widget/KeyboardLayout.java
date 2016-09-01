package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean BZ;
    private boolean aGd;
    private a aGe;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aK(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGd = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGd = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aGd = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aGe = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aGd) {
            this.aGd = true;
            this.mHeight = i4;
            if (this.aGe != null) {
                this.aGe.aK(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aGd && this.mHeight > i4) {
            this.BZ = true;
            if (this.aGe != null) {
                this.aGe.aK(-3);
            }
        }
        if (this.aGd && this.BZ && this.mHeight == i4) {
            this.BZ = false;
            if (this.aGe != null) {
                this.aGe.aK(-2);
            }
        }
    }
}
