package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View auw;
    private boolean aux;

    public a(View view) {
        this.auw = view;
    }

    public boolean CS() {
        return this.aux;
    }

    public void c(View view, boolean z) {
        if (view != null && this.auw != null && this.auw.getParent() == null) {
            this.aux = true;
            d.N(view).a(view, this.auw, z);
            CT();
        }
    }

    public void L(View view) {
        if (view != null && this.auw != null && this.auw.getParent() != null && (view instanceof ViewGroup)) {
            try {
                CU();
                ((ViewGroup) view).removeView(this.auw);
                this.aux = false;
            } catch (Exception e) {
            }
        }
    }

    public void M(View view) {
        c(view, false);
    }

    protected void CT() {
    }

    protected void CU() {
    }
}
