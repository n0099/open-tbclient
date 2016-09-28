package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View ayL;
    private boolean ayM;

    public a(View view) {
        this.ayL = view;
    }

    public boolean Eu() {
        return this.ayM;
    }

    public void b(View view, boolean z) {
        if (view != null && this.ayL != null && this.ayL.getParent() == null) {
            this.ayM = true;
            d.N(view).a(view, this.ayL, z);
            Ev();
        }
    }

    public void L(View view) {
        if (view != null && this.ayL != null && this.ayL.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ew();
                ((ViewGroup) view).removeView(this.ayL);
                this.ayM = false;
            } catch (Exception e) {
            }
        }
    }

    public void M(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ev() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ew() {
    }
}
