package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aGw;
    private boolean aGx;

    public a(View view) {
        this.aGw = view;
    }

    public boolean EI() {
        return this.aGx;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aGw != null && this.aGw.getParent() == null) {
            this.aGx = true;
            d.P(view).a(view, this.aGw, z);
            EJ();
        }
    }

    public void N(View view) {
        if (view != null && this.aGw != null && this.aGw.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EK();
                ((ViewGroup) view).removeView(this.aGw);
                this.aGx = false;
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
