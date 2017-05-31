package com.baidu.tbadk.i;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aDt;
    private boolean aDu;

    public a(View view) {
        this.aDt = view;
    }

    public boolean DR() {
        return this.aDu;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aDt != null && this.aDt.getParent() == null) {
            this.aDu = true;
            d.J(view).a(view, this.aDt, z);
            DS();
        }
    }

    public void H(View view) {
        if (view != null && this.aDt != null && this.aDt.getParent() != null && (view instanceof ViewGroup)) {
            try {
                DT();
                ((ViewGroup) view).removeView(this.aDt);
                this.aDu = false;
            } catch (Exception e) {
            }
        }
    }

    public void I(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DT() {
    }
}
