package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean BZ;
    private boolean aGs;
    private a aGt;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aK(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGs = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGs = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aGs = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aGt = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aGs) {
            this.aGs = true;
            this.mHeight = i4;
            if (this.aGt != null) {
                this.aGt.aK(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aGs && this.mHeight > i4) {
            this.BZ = true;
            if (this.aGt != null) {
                this.aGt.aK(-3);
            }
        }
        if (this.aGs && this.BZ && this.mHeight == i4) {
            this.BZ = false;
            if (this.aGt != null) {
                this.aGt.aK(-2);
            }
        }
    }
}
