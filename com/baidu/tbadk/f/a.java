package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View azD;
    private boolean azE;

    public a(View view) {
        this.azD = view;
    }

    public boolean Ez() {
        return this.azE;
    }

    public void b(View view, boolean z) {
        if (view != null && this.azD != null && this.azD.getParent() == null) {
            this.azE = true;
            d.O(view).a(view, this.azD, z);
            EA();
        }
    }

    public void M(View view) {
        if (view != null && this.azD != null && this.azD.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EB();
                ((ViewGroup) view).removeView(this.azD);
                this.azE = false;
            } catch (Exception e) {
            }
        }
    }

    public void N(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EB() {
    }
}
