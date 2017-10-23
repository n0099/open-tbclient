package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aFK;
    private boolean aFL;

    public a(View view) {
        this.aFK = view;
    }

    public boolean Eh() {
        return this.aFL;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aFK != null && this.aFK.getParent() == null) {
            this.aFL = true;
            d.Q(view).a(view, this.aFK, z);
            Ei();
        }
    }

    public void O(View view) {
        if (view != null && this.aFK != null && this.aFK.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ej();
                ((ViewGroup) view).removeView(this.aFK);
                this.aFL = false;
            } catch (Exception e) {
            }
        }
    }

    public void P(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ei() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ej() {
    }
}
