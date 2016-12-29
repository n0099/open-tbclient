package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aza;
    private boolean azb;

    public a(View view) {
        this.aza = view;
    }

    public boolean Eh() {
        return this.azb;
    }

    public void b(View view, boolean z) {
        if (view != null && this.aza != null && this.aza.getParent() == null) {
            this.azb = true;
            d.O(view).a(view, this.aza, z);
            Ei();
        }
    }

    public void M(View view) {
        if (view != null && this.aza != null && this.aza.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ej();
                ((ViewGroup) view).removeView(this.aza);
                this.azb = false;
            } catch (Exception e) {
            }
        }
    }

    public void N(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ei() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ej() {
    }
}
