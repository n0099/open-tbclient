package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aRh;
    private boolean aRi;

    public a(View view) {
        this.aRh = view;
    }

    public boolean Jh() {
        return this.aRi;
    }

    public void d(View view, boolean z) {
        if (view != null && this.aRh != null && this.aRh.getParent() == null) {
            this.aRi = true;
            d.R(view).a(view, this.aRh, z);
            Ji();
        }
    }

    public void Q(View view) {
        if (view != null && this.aRh != null && this.aRh.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Jj();
                ((ViewGroup) view).removeView(this.aRh);
                this.aRi = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        d(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ji() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jj() {
    }
}
