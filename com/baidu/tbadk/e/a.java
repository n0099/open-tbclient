package com.baidu.tbadk.e;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View auA;
    private boolean auB;

    public a(View view) {
        this.auA = view;
    }

    public boolean Cq() {
        return this.auB;
    }

    public void b(View view, boolean z) {
        if (view != null && this.auA != null && this.auA.getParent() == null) {
            this.auB = true;
            d.w(view).a(view, this.auA, z);
            Cr();
        }
    }

    public void u(View view) {
        if (view != null && this.auA != null && this.auA.getParent() != null && (view instanceof ViewGroup)) {
            Cs();
            ((ViewGroup) view).removeView(this.auA);
            this.auB = false;
        }
    }

    public void v(View view) {
        b(view, false);
    }

    protected void Cr() {
    }

    protected void Cs() {
    }
}
