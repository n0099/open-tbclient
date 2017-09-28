package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aFX;
    private boolean aFY;

    public a(View view) {
        this.aFX = view;
    }

    public boolean En() {
        return this.aFY;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aFX != null && this.aFX.getParent() == null) {
            this.aFY = true;
            d.Q(view).a(view, this.aFX, z);
            Eo();
        }
    }

    public void O(View view) {
        if (view != null && this.aFX != null && this.aFX.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ep();
                ((ViewGroup) view).removeView(this.aFX);
                this.aFY = false;
            } catch (Exception e) {
            }
        }
    }

    public void P(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Eo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ep() {
    }
}
