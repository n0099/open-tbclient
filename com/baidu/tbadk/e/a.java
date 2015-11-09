package com.baidu.tbadk.e;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View atp;
    private boolean atq;

    public a(View view) {
        this.atp = view;
    }

    public boolean Cg() {
        return this.atq;
    }

    public void b(View view, boolean z) {
        if (view != null && this.atp != null && this.atp.getParent() == null) {
            this.atq = true;
            d.w(view).a(view, this.atp, z);
            Ch();
        }
    }

    public void u(View view) {
        if (view != null && this.atp != null && this.atp.getParent() != null && (view instanceof ViewGroup)) {
            Ci();
            ((ViewGroup) view).removeView(this.atp);
            this.atq = false;
        }
    }

    public void v(View view) {
        b(view, false);
    }

    protected void Ch() {
    }

    protected void Ci() {
    }
}
