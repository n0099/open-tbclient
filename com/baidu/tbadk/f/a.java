package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View ayv;
    private boolean ayw;

    public a(View view) {
        this.ayv = view;
    }

    public boolean Fa() {
        return this.ayw;
    }

    public void c(View view, boolean z) {
        if (view != null && this.ayv != null && this.ayv.getParent() == null) {
            this.ayw = true;
            d.M(view).a(view, this.ayv, z);
            Fb();
        }
    }

    public void K(View view) {
        if (view != null && this.ayv != null && this.ayv.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Fc();
                ((ViewGroup) view).removeView(this.ayv);
                this.ayw = false;
            } catch (Exception e) {
            }
        }
    }

    public void L(View view) {
        c(view, false);
    }

    protected void Fb() {
    }

    protected void Fc() {
    }
}
