package com.baidu.tbadk.i;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aEH;
    private boolean aEI;

    public a(View view) {
        this.aEH = view;
    }

    public boolean Eo() {
        return this.aEI;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aEH != null && this.aEH.getParent() == null) {
            this.aEI = true;
            d.K(view).a(view, this.aEH, z);
            Ep();
        }
    }

    public void I(View view) {
        if (view != null && this.aEH != null && this.aEH.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Eq();
                ((ViewGroup) view).removeView(this.aEH);
                this.aEI = false;
            } catch (Exception e) {
            }
        }
    }

    public void J(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ep() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Eq() {
    }
}
