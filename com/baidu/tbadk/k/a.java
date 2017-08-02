package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aFP;
    private boolean aFQ;

    public a(View view) {
        this.aFP = view;
    }

    public boolean EC() {
        return this.aFQ;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aFP != null && this.aFP.getParent() == null) {
            this.aFQ = true;
            d.K(view).a(view, this.aFP, z);
            ED();
        }
    }

    public void I(View view) {
        if (view != null && this.aFP != null && this.aFP.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EE();
                ((ViewGroup) view).removeView(this.aFP);
                this.aFQ = false;
            } catch (Exception e) {
            }
        }
    }

    public void J(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ED() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EE() {
    }
}
