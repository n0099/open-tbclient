package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHg;
    private boolean aHh;

    public a(View view) {
        this.aHg = view;
    }

    public boolean EK() {
        return this.aHh;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aHg != null && this.aHg.getParent() == null) {
            this.aHh = true;
            d.K(view).a(view, this.aHg, z);
            EL();
        }
    }

    public void I(View view) {
        if (view != null && this.aHg != null && this.aHg.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EM();
                ((ViewGroup) view).removeView(this.aHg);
                this.aHh = false;
            } catch (Exception e) {
            }
        }
    }

    public void J(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EL() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EM() {
    }
}
