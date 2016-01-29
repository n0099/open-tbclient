package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View axO;
    private boolean axP;

    public a(View view) {
        this.axO = view;
    }

    public boolean Eo() {
        return this.axP;
    }

    public void c(View view, boolean z) {
        if (view != null && this.axO != null && this.axO.getParent() == null) {
            this.axP = true;
            d.J(view).a(view, this.axO, z);
            Ep();
        }
    }

    public void H(View view) {
        if (view != null && this.axO != null && this.axO.getParent() != null && (view instanceof ViewGroup)) {
            Eq();
            ((ViewGroup) view).removeView(this.axO);
            this.axP = false;
        }
    }

    public void I(View view) {
        c(view, false);
    }

    protected void Ep() {
    }

    protected void Eq() {
    }
}
