package com.baidu.tbadk.d;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View abX;
    private boolean abY;

    public a(View view) {
        this.abX = view;
    }

    public boolean wi() {
        return this.abY;
    }

    public void b(View view, boolean z) {
        if (view != null && this.abX != null && this.abX.getParent() == null) {
            this.abY = true;
            d.q(view).a(view, this.abX, z);
            wj();
        }
    }

    public void p(View view) {
        if (view != null && this.abX != null && this.abX.getParent() != null && (view instanceof ViewGroup)) {
            wk();
            ((ViewGroup) view).removeView(this.abX);
            this.abY = false;
        }
    }

    protected void wj() {
    }

    protected void wk() {
    }
}
