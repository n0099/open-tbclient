package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHe;
    private boolean aHf;

    public a(View view) {
        this.aHe = view;
    }

    public boolean EN() {
        return this.aHf;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aHe != null && this.aHe.getParent() == null) {
            this.aHf = true;
            d.Q(view).a(view, this.aHe, z);
            EO();
        }
    }

    public void O(View view) {
        if (view != null && this.aHe != null && this.aHe.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EP();
                ((ViewGroup) view).removeView(this.aHe);
                this.aHf = false;
            } catch (Exception e) {
            }
        }
    }

    public void P(View view) {
        c(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EO() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EP() {
    }
}
