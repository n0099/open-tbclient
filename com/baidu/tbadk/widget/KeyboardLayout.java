package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HP;
    private boolean aCi;
    private a aCj;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCi = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCi = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aCi = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aCj = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aCi) {
            this.aCi = true;
            this.mHeight = i4;
            if (this.aCj != null) {
                this.aCj.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aCi && this.mHeight > i4) {
            this.HP = true;
            if (this.aCj != null) {
                this.aCj.onKeyBoardStateChange(-3);
            }
        }
        if (this.aCi && this.HP && this.mHeight == i4) {
            this.HP = false;
            if (this.aCj != null) {
                this.aCj.onKeyBoardStateChange(-2);
            }
        }
    }
}
