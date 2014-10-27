package com.baidu.tieba.editortool;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] aqs = {com.baidu.tieba.r.custom_state_focused};
    protected static final int[] aqt = {com.baidu.tieba.r.custom_state_skin};
    protected TextView Hl;
    protected boolean aqo;
    protected boolean aqp;
    protected boolean aqq;
    protected boolean aqr;
    protected Context mContext;
    protected int mSkinType;

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public EditorToolButton(Context context) {
        super(context);
        this.aqo = false;
        this.aqp = true;
        this.aqq = false;
        this.aqr = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqo = false;
        this.aqp = true;
        this.aqq = false;
        this.aqr = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.custom_state);
        this.aqo = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.aqo) {
            mergeDrawableStates(onCreateDrawableState, aqs);
        }
        return onCreateDrawableState;
    }

    public void Ba() {
        if (!this.aqr) {
            setVisibility(0);
        }
    }

    public TextView getTip() {
        return this.Hl;
    }

    public void hide() {
        setVisibility(8);
    }

    public void enable() {
        setEnabled(true);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!this.aqq) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void f(TextView textView) {
        this.Hl = textView;
    }

    public void qj() {
        if (this.Hl != null) {
            this.Hl.setVisibility(0);
        }
    }

    public void eG(String str) {
        if (this.Hl != null) {
            this.Hl.setVisibility(0);
            this.Hl.setText(str);
        }
    }

    public void qk() {
        if (this.Hl != null) {
            this.Hl.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.aqp = z;
        if (!z) {
            Bd();
        }
    }

    public boolean Bb() {
        return this.aqp;
    }

    public void setHardDisabled(boolean z) {
        this.aqq = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.aqr = z;
        hide();
    }

    public void Bc() {
        this.aqo = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.aqo;
    }

    public void Bd() {
        this.aqo = false;
        refreshDrawableState();
    }
}
