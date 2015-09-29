package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HP;
    private boolean aAB;
    private a aAC;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAB = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAB = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.aAB = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.aAC = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.aAB) {
            this.aAB = true;
            this.mHeight = i4;
            if (this.aAC != null) {
                this.aAC.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.aAB && this.mHeight > i4) {
            this.HP = true;
            if (this.aAC != null) {
                this.aAC.onKeyBoardStateChange(-3);
            }
        }
        if (this.aAB && this.HP && this.mHeight == i4) {
            this.HP = false;
            if (this.aAC != null) {
                this.aAC.onKeyBoardStateChange(-2);
            }
        }
    }
}
