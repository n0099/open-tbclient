package com.baidu.tieba.editortool;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] aqB = {com.baidu.tieba.r.custom_state_focused};
    protected static final int[] aqC = {com.baidu.tieba.r.custom_state_skin};
    protected TextView Hm;
    protected boolean aqA;
    protected boolean aqx;
    protected boolean aqy;
    protected boolean aqz;
    protected Context mContext;
    protected int mSkinType;

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public EditorToolButton(Context context) {
        super(context);
        this.aqx = false;
        this.aqy = true;
        this.aqz = false;
        this.aqA = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqx = false;
        this.aqy = true;
        this.aqz = false;
        this.aqA = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.custom_state);
        this.aqx = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.aqx) {
            mergeDrawableStates(onCreateDrawableState, aqB);
        }
        return onCreateDrawableState;
    }

    public void Bc() {
        if (!this.aqA) {
            setVisibility(0);
        }
    }

    public TextView getTip() {
        return this.Hm;
    }

    public void hide() {
        setVisibility(8);
    }

    public void enable() {
        setEnabled(true);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!this.aqz) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void f(TextView textView) {
        this.Hm = textView;
    }

    public void ql() {
        if (this.Hm != null) {
            this.Hm.setVisibility(0);
        }
    }

    public void eG(String str) {
        if (this.Hm != null) {
            this.Hm.setVisibility(0);
            this.Hm.setText(str);
        }
    }

    public void qm() {
        if (this.Hm != null) {
            this.Hm.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.aqy = z;
        if (!z) {
            Bf();
        }
    }

    public boolean Bd() {
        return this.aqy;
    }

    public void setHardDisabled(boolean z) {
        this.aqz = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.aqA = z;
        hide();
    }

    public void Be() {
        this.aqx = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.aqx;
    }

    public void Bf() {
        this.aqx = false;
        refreshDrawableState();
    }
}
