package com.baidu.tbadk.d;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aca;
    private boolean acb;

    public a(View view) {
        this.aca = view;
    }

    public boolean wo() {
        return this.acb;
    }

    public void b(View view, boolean z) {
        if (view != null && this.aca != null && this.aca.getParent() == null) {
            this.acb = true;
            d.q(view).a(view, this.aca, z);
            wp();
        }
    }

    public void p(View view) {
        if (view != null && this.aca != null && this.aca.getParent() != null && (view instanceof ViewGroup)) {
            wq();
            ((ViewGroup) view).removeView(this.aca);
            this.acb = false;
        }
    }

    protected void wp() {
    }

    protected void wq() {
    }
}
