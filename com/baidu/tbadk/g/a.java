package com.baidu.tbadk.g;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View avm;
    private boolean avn;

    public a(View view) {
        this.avm = view;
    }

    public boolean Db() {
        return this.avn;
    }

    public void c(View view, boolean z) {
        if (view != null && this.avm != null && this.avm.getParent() == null) {
            this.avn = true;
            d.M(view).a(view, this.avm, z);
            Dc();
        }
    }

    public void K(View view) {
        if (view != null && this.avm != null && this.avm.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Dd();
                ((ViewGroup) view).removeView(this.avm);
                this.avn = false;
            } catch (Exception e) {
            }
        }
    }

    public void L(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dd() {
    }
}
