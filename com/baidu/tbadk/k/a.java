package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aYV;
    private boolean aYW;

    public a(View view) {
        this.aYV = view;
    }

    public boolean Mq() {
        return this.aYW;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aYV != null && this.aYV.getParent() == null) {
            this.aYW = true;
            d.ae(view).a(view, this.aYV, z);
            Mr();
        }
    }

    public void ad(View view) {
        if (view != null && this.aYV != null && this.aYV.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Ms();
                ((ViewGroup) view).removeView(this.aYV);
                this.aYW = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ms() {
    }
}
