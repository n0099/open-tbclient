package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aQl;
    private boolean aQm;

    public a(View view) {
        this.aQl = view;
    }

    public boolean IP() {
        return this.aQm;
    }

    public void d(View view, boolean z) {
        if (view != null && this.aQl != null && this.aQl.getParent() == null) {
            this.aQm = true;
            d.Q(view).a(view, this.aQl, z);
            IQ();
        }
    }

    public void P(View view) {
        if (view != null && this.aQl != null && this.aQl.getParent() != null && (view instanceof ViewGroup)) {
            try {
                IR();
                ((ViewGroup) view).removeView(this.aQl);
                this.aQm = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        d(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IQ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IR() {
    }
}
