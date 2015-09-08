package com.baidu.tbadk.e;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View awc;
    private boolean awd;

    public a(View view) {
        this.awc = view;
    }

    public boolean CE() {
        return this.awd;
    }

    public void b(View view, boolean z) {
        if (view != null && this.awc != null && this.awc.getParent() == null) {
            this.awd = true;
            d.w(view).a(view, this.awc, z);
            CF();
        }
    }

    public void u(View view) {
        if (view != null && this.awc != null && this.awc.getParent() != null && (view instanceof ViewGroup)) {
            CG();
            ((ViewGroup) view).removeView(this.awc);
            this.awd = false;
        }
    }

    public void v(View view) {
        b(view, false);
    }

    protected void CF() {
    }

    protected void CG() {
    }
}
