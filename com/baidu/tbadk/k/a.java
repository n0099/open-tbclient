package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    private boolean aGA;
    protected View aGz;

    public a(View view) {
        this.aGz = view;
    }

    public boolean EI() {
        return this.aGA;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aGz != null && this.aGz.getParent() == null) {
            this.aGA = true;
            d.P(view).a(view, this.aGz, z);
            EJ();
        }
    }

    public void N(View view) {
        if (view != null && this.aGz != null && this.aGz.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EK();
                ((ViewGroup) view).removeView(this.aGz);
                this.aGA = false;
            } catch (Exception e) {
            }
        }
    }

    public void O(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EJ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EK() {
    }
}
