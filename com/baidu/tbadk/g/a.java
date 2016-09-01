package com.baidu.tbadk.g;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View azi;
    private boolean azj;

    public a(View view) {
        this.azi = view;
    }

    public boolean Eu() {
        return this.azj;
    }

    public void b(View view, boolean z) {
        if (view != null && this.azi != null && this.azi.getParent() == null) {
            this.azj = true;
            d.N(view).a(view, this.azi, z);
            Ev();
        }
    }

    public void L(View view) {
        if (view != null && this.azi != null && this.azi.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ew();
                ((ViewGroup) view).removeView(this.azi);
                this.azj = false;
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
