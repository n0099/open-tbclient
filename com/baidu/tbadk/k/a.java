package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aUw;
    private boolean aUx;

    public a(View view) {
        this.aUw = view;
    }

    public boolean Ks() {
        return this.aUx;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aUw != null && this.aUw.getParent() == null) {
            this.aUx = true;
            d.ae(view).a(view, this.aUw, z);
            Kt();
        }
    }

    public void ad(View view) {
        if (view != null && this.aUw != null && this.aUw.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ku();
                ((ViewGroup) view).removeView(this.aUw);
                this.aUx = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kt() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ku() {
    }
}
