package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aCg;
    private a aCh;
    private int mHeight;
    private boolean zj;

    /* loaded from: classes.dex */
    public interface a {
        void au(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCg = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCg = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aCg = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aCh = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aCg) {
            this.aCg = true;
            this.mHeight = i4;
            if (this.aCh != null) {
                this.aCh.au(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aCg && this.mHeight > i4) {
            this.zj = true;
            if (this.aCh != null) {
                this.aCh.au(-3);
            }
        }
        if (this.aCg && this.zj && this.mHeight == i4) {
            this.zj = false;
            if (this.aCh != null) {
                this.aCh.au(-2);
            }
        }
    }
}
