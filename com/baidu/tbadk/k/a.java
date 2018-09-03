package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aRe;
    private boolean aRf;

    public a(View view) {
        this.aRe = view;
    }

    public boolean Jc() {
        return this.aRf;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aRe != null && this.aRe.getParent() == null) {
            this.aRf = true;
            d.R(view).a(view, this.aRe, z);
            Jd();
        }
    }

    public void Q(View view) {
        if (view != null && this.aRe != null && this.aRe.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Je();
                ((ViewGroup) view).removeView(this.aRe);
                this.aRf = false;
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
