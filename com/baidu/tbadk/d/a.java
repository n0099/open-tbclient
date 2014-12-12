package com.baidu.tbadk.d;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View abD;
    private boolean abE;

    public a(View view) {
        this.abD = view;
    }

    public boolean vW() {
        return this.abE;
    }

    public void b(View view, boolean z) {
        if (view != null && this.abD != null && this.abD.getParent() == null) {
            this.abE = true;
            d.q(view).a(view, this.abD, z);
            vX();
        }
    }

    public void p(View view) {
        if (view != null && this.abD != null && this.abD.getParent() != null && (view instanceof ViewGroup)) {
            vY();
            ((ViewGroup) view).removeView(this.abD);
            this.abE = false;
        }
    }

    protected void vX() {
    }

    protected void vY() {
    }
}
