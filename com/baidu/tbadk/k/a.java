package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aRh;
    private boolean aRi;

    public a(View view) {
        this.aRh = view;
    }

    public boolean Jc() {
        return this.aRi;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aRh != null && this.aRh.getParent() == null) {
            this.aRi = true;
            d.R(view).a(view, this.aRh, z);
            Jd();
        }
    }

    public void Q(View view) {
        if (view != null && this.aRh != null && this.aRh.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Je();
                ((ViewGroup) view).removeView(this.aRh);
                this.aRi = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Je() {
    }
}
