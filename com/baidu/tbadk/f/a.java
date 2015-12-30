package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View awX;
    private boolean awY;

    public a(View view) {
        this.awX = view;
    }

    public boolean CW() {
        return this.awY;
    }

    public void b(View view, boolean z) {
        if (view != null && this.awX != null && this.awX.getParent() == null) {
            this.awY = true;
            d.w(view).a(view, this.awX, z);
            CX();
        }
    }

    public void u(View view) {
        if (view != null && this.awX != null && this.awX.getParent() != null && (view instanceof ViewGroup)) {
            CY();
            ((ViewGroup) view).removeView(this.awX);
            this.awY = false;
        }
    }

    public void v(View view) {
        b(view, false);
    }

    protected void CX() {
    }

    protected void CY() {
    }
}
