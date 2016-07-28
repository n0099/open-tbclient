package com.baidu.tbadk.g;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View awb;
    private boolean awc;

    public a(View view) {
        this.awb = view;
    }

    public boolean Da() {
        return this.awc;
    }

    public void c(View view, boolean z) {
        if (view != null && this.awb != null && this.awb.getParent() == null) {
            this.awc = true;
            d.M(view).a(view, this.awb, z);
            Db();
        }
    }

    public void K(View view) {
        if (view != null && this.awb != null && this.awb.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Dc();
                ((ViewGroup) view).removeView(this.awb);
                this.awc = false;
            } catch (Exception e) {
            }
        }
    }

    public void L(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Db() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dc() {
    }
}
