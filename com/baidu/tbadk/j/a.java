package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHi;
    private boolean aHj;

    public a(View view) {
        this.aHi = view;
    }

    public boolean EO() {
        return this.aHj;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aHi != null && this.aHi.getParent() == null) {
            this.aHj = true;
            d.R(view).a(view, this.aHi, z);
            EP();
        }
    }

    public void P(View view) {
        if (view != null && this.aHi != null && this.aHi.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EQ();
                ((ViewGroup) view).removeView(this.aHi);
                this.aHj = false;
            } catch (Exception e) {
            }
        }
    }

    public void Q(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EP() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EQ() {
    }
}
