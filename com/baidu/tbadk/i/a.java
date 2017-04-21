package com.baidu.tbadk.i;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aDH;
    private boolean aDI;

    public a(View view) {
        this.aDH = view;
    }

    public boolean ET() {
        return this.aDI;
    }

    public void b(View view, boolean z) {
        if (view != null && this.aDH != null && this.aDH.getParent() == null) {
            this.aDI = true;
            d.K(view).a(view, this.aDH, z);
            EU();
        }
    }

    public void I(View view) {
        if (view != null && this.aDH != null && this.aDH.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EV();
                ((ViewGroup) view).removeView(this.aDH);
                this.aDI = false;
            } catch (Exception e) {
            }
        }
    }

    public void J(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EV() {
    }
}
