package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHh;
    private boolean aHi;

    public a(View view) {
        this.aHh = view;
    }

    public boolean EK() {
        return this.aHi;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aHh != null && this.aHh.getParent() == null) {
            this.aHi = true;
            d.K(view).a(view, this.aHh, z);
            EL();
        }
    }

    public void I(View view) {
        if (view != null && this.aHh != null && this.aHh.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EM();
                ((ViewGroup) view).removeView(this.aHh);
                this.aHi = false;
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
