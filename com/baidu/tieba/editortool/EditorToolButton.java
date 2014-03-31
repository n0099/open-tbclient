package com.baidu.tieba.editortool;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] h = {com.baidu.tieba.a.d.custom_state_focused};
    protected static final int[] i = {com.baidu.tieba.a.d.custom_state_skin};
    protected TextView a;
    protected Context b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected int g;

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public EditorToolButton(Context context) {
        super(context);
        this.c = false;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.b = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.b = context;
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(attributeSet, com.baidu.tieba.a.m.custom_state);
        this.c = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.c) {
            mergeDrawableStates(onCreateDrawableState, h);
        }
        return onCreateDrawableState;
    }

    public final void a() {
        if (!this.f) {
            setVisibility(0);
        }
    }

    public TextView getTip() {
        return this.a;
    }

    public final void b() {
        setVisibility(8);
    }

    public final void c() {
        setEnabled(true);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!this.e) {
            super.setEnabled(z);
        }
    }

    public final void d() {
        setEnabled(false);
    }

    public final void a(TextView textView) {
        this.a = textView;
    }

    public final void e() {
        if (this.a != null) {
            this.a.setVisibility(0);
        }
    }

    public final void a(String str) {
        if (this.a != null) {
            this.a.setVisibility(0);
            this.a.setText(str);
        }
    }

    public final void f() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.d = z;
        if (!z) {
            i();
        }
    }

    public final boolean g() {
        return this.d;
    }

    public void setHardDisabled(boolean z) {
        this.e = z;
        setEnabled(false);
    }

    public void setHardInvisible(boolean z) {
        this.f = z;
        setVisibility(8);
    }

    public final void h() {
        this.c = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.c;
    }

    public final void i() {
        this.c = false;
        refreshDrawableState();
    }
}
