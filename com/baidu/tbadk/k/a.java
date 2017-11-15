package com.baidu.tbadk.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aGC;
    private boolean aGD;

    public a(View view) {
        this.aGC = view;
    }

    public boolean EG() {
        return this.aGD;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aGC != null && this.aGC.getParent() == null) {
            this.aGD = true;
            d.Q(view).a(view, this.aGC, z);
            EH();
        }
    }

    public void O(View view) {
        if (view != null && this.aGC != null && this.aGC.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EI();
                ((ViewGroup) view).removeView(this.aGC);
                this.aGD = false;
            } catch (Exception e) {
            }
        }
    }

    public void P(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EH() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EI() {
    }
}
