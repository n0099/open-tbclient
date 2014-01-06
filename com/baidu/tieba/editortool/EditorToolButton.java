package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.au;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] h = {R.attr.custom_state_focused};
    protected static final int[] i = {R.attr.custom_state_skin};
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
        this.c = this.b.obtainStyledAttributes(attributeSet, au.custom_state).getBoolean(1, false);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.c) {
            mergeDrawableStates(onCreateDrawableState, h);
        }
        return onCreateDrawableState;
    }

    public void a() {
        if (!this.f) {
            setVisibility(0);
        }
    }

    public TextView getTip() {
        return this.a;
    }

    public void b() {
        setVisibility(8);
    }

    public void c() {
        setEnabled(true);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!this.e) {
            super.setEnabled(z);
        }
    }

    public void d() {
        setEnabled(false);
    }

    public void a(TextView textView) {
        this.a = textView;
    }

    public void e() {
        if (this.a != null) {
            this.a.setVisibility(0);
        }
    }

    public void f() {
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

    public boolean g() {
        return this.d;
    }

    public void setHardDisabled(boolean z) {
        this.e = z;
        d();
    }

    public void setHardInvisible(boolean z) {
        this.f = z;
        b();
    }

    public void h() {
        this.c = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.c;
    }

    public void i() {
        this.c = false;
        refreshDrawableState();
    }
}
