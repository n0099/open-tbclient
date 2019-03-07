package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean cvk;
    private a cvl;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aU(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvk = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvk = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.cvk = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.cvl = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.cvk) {
            this.cvk = true;
            this.mHeight = i4;
            if (this.cvl != null) {
                this.cvl.aU(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.cvk && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.cvl != null) {
                this.cvl.aU(-3);
            }
        }
        if (this.cvk && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.cvl != null) {
                this.cvl.aU(-2);
            }
        }
    }
}
