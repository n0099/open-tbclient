package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aBG;
    private a aBH;
    private int mHeight;
    private boolean zk;

    /* loaded from: classes.dex */
    public interface a {
        void au(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBG = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBG = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aBG = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aBH = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aBG) {
            this.aBG = true;
            this.mHeight = i4;
            if (this.aBH != null) {
                this.aBH.au(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aBG && this.mHeight > i4) {
            this.zk = true;
            if (this.aBH != null) {
                this.aBH.au(-3);
            }
        }
        if (this.aBG && this.zk && this.mHeight == i4) {
            this.zk = false;
            if (this.aBH != null) {
                this.aBH.au(-2);
            }
        }
    }
}
