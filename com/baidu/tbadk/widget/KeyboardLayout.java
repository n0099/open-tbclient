package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean HR;
    private boolean azA;
    private a azB;
    private int mHeight;

    /* loaded from: classes.dex */
    public interface a {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azA = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azA = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.azA = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.azB = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.azA) {
            this.azA = true;
            this.mHeight = i4;
            if (this.azB != null) {
                this.azB.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.azA && this.mHeight > i4) {
            this.HR = true;
            if (this.azB != null) {
                this.azB.onKeyBoardStateChange(-3);
            }
        }
        if (this.azA && this.HR && this.mHeight == i4) {
            this.HR = false;
            if (this.azB != null) {
                this.azB.onKeyBoardStateChange(-2);
            }
        }
    }
}
