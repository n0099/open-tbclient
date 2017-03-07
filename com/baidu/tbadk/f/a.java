package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aDp;
    private boolean aDq;

    public a(View view) {
        this.aDp = view;
    }

    public boolean Ev() {
        return this.aDq;
    }

    public void b(View view, boolean z) {
        if (view != null && this.aDp != null && this.aDp.getParent() == null) {
            this.aDq = true;
            d.K(view).a(view, this.aDp, z);
            Ew();
        }
    }

    public void I(View view) {
        if (view != null && this.aDp != null && this.aDp.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ex();
                ((ViewGroup) view).removeView(this.aDp);
                this.aDq = false;
            } catch (Exception e) {
            }
        }
    }

    public void J(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ew() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ex() {
    }
}
