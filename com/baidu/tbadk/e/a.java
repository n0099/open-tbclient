package com.baidu.tbadk.e;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View auB;
    private boolean auC;

    public a(View view) {
        this.auB = view;
    }

    public boolean Cq() {
        return this.auC;
    }

    public void b(View view, boolean z) {
        if (view != null && this.auB != null && this.auB.getParent() == null) {
            this.auC = true;
            d.w(view).a(view, this.auB, z);
            Cr();
        }
    }

    public void u(View view) {
        if (view != null && this.auB != null && this.auB.getParent() != null && (view instanceof ViewGroup)) {
            Cs();
            ((ViewGroup) view).removeView(this.auB);
            this.auC = false;
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
