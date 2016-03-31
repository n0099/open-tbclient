package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean IT;
    private boolean aFw;
    private a aFx;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aG(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFw = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFw = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aFw = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aFx = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aFw) {
            this.aFw = true;
            this.mHeight = i4;
            if (this.aFx != null) {
                this.aFx.aG(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aFw && this.mHeight > i4) {
            this.IT = true;
            if (this.aFx != null) {
                this.aFx.aG(-3);
            }
        }
        if (this.aFw && this.IT && this.mHeight == i4) {
            this.IT = false;
            if (this.aFx != null) {
                this.aFx.aG(-2);
            }
        }
    }
}
