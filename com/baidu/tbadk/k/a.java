package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHf;
    private boolean aHg;

    public a(View view) {
        this.aHf = view;
    }

    public boolean EK() {
        return this.aHg;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aHf != null && this.aHf.getParent() == null) {
            this.aHg = true;
            d.K(view).a(view, this.aHf, z);
            EL();
        }
    }

    public void I(View view) {
        if (view != null && this.aHf != null && this.aHf.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EM();
                ((ViewGroup) view).removeView(this.aHf);
                this.aHg = false;
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
