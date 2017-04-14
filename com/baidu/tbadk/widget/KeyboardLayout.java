package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aKo;
    private a aKp;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aJ(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKo = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKo = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aKo = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aKp = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aKo) {
            this.aKo = true;
            this.mHeight = i4;
            if (this.aKp != null) {
                this.aKp.aJ(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aKo && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aKp != null) {
                this.aKp.aJ(-3);
            }
        }
        if (this.aKo && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aKp != null) {
                this.aKp.aJ(-2);
            }
        }
    }
}
