package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aGu;
    private boolean aGv;

    public a(View view) {
        this.aGu = view;
    }

    public boolean Eu() {
        return this.aGv;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aGu != null && this.aGu.getParent() == null) {
            this.aGv = true;
            d.Q(view).a(view, this.aGu, z);
            Ev();
        }
    }

    public void O(View view) {
        if (view != null && this.aGu != null && this.aGu.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ew();
                ((ViewGroup) view).removeView(this.aGu);
                this.aGv = false;
            } catch (Exception e) {
            }
        }
    }

    public void P(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ev() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ew() {
    }
}
