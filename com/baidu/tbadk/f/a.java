package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View axV;
    private boolean axW;

    public a(View view) {
        this.axV = view;
    }

    public boolean Ec() {
        return this.axW;
    }

    public void b(View view, boolean z) {
        if (view != null && this.axV != null && this.axV.getParent() == null) {
            this.axW = true;
            d.M(view).a(view, this.axV, z);
            Ed();
        }
    }

    public void K(View view) {
        if (view != null && this.axV != null && this.axV.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ee();
                ((ViewGroup) view).removeView(this.axV);
                this.axW = false;
            } catch (Exception e) {
            }
        }
    }

    public void L(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ee() {
    }
}
