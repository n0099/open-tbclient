package com.baidu.tbadk.i;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aDF;
    private boolean aDG;

    public a(View view) {
        this.aDF = view;
    }

    public boolean ET() {
        return this.aDG;
    }

    public void b(View view, boolean z) {
        if (view != null && this.aDF != null && this.aDF.getParent() == null) {
            this.aDG = true;
            d.K(view).a(view, this.aDF, z);
            EU();
        }
    }

    public void I(View view) {
        if (view != null && this.aDF != null && this.aDF.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EV();
                ((ViewGroup) view).removeView(this.aDF);
                this.aDG = false;
            } catch (Exception e) {
            }
        }
    }

    public void J(View view) {
        b(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EV() {
    }
}
