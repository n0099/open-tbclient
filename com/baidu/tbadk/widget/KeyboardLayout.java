package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HP;
    private boolean aAA;
    private a aAB;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAA = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAA = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aAA = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aAB = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aAA) {
            this.aAA = true;
            this.mHeight = i4;
            if (this.aAB != null) {
                this.aAB.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aAA && this.mHeight > i4) {
            this.HP = true;
            if (this.aAB != null) {
                this.aAB.onKeyBoardStateChange(-3);
            }
        }
        if (this.aAA && this.HP && this.mHeight == i4) {
            this.HP = false;
            if (this.aAB != null) {
                this.aAB.onKeyBoardStateChange(-2);
            }
        }
    }
}
