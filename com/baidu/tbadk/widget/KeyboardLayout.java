package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean aNu;
    private a aNv;
    private boolean mHasKeybord;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aN(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNu = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNu = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aNu = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aNv = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aNu) {
            this.aNu = true;
            this.mHeight = i4;
            if (this.aNv != null) {
                this.aNv.aN(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aNu && this.mHeight > i4) {
            this.mHasKeybord = true;
            if (this.aNv != null) {
                this.aNv.aN(-3);
            }
        }
        if (this.aNu && this.mHasKeybord && this.mHeight == i4) {
            this.mHasKeybord = false;
            if (this.aNv != null) {
                this.aNv.aN(-2);
            }
        }
    }
}
