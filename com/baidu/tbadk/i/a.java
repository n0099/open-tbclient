package com.baidu.tbadk.i;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aDG;
    private boolean aDH;

    public a(View view) {
        this.aDG = view;
    }

    public boolean DX() {
        return this.aDH;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aDG != null && this.aDG.getParent() == null) {
            this.aDH = true;
            d.J(view).a(view, this.aDG, z);
            DY();
        }
    }

    public void H(View view) {
        if (view != null && this.aDG != null && this.aDG.getParent() != null && (view instanceof ViewGroup)) {
            try {
                DZ();
                ((ViewGroup) view).removeView(this.aDG);
                this.aDH = false;
            } catch (Exception e) {
            }
        }
    }

    public void I(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DZ() {
    }
}
