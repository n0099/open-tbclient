package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHl;
    private boolean aHm;

    public a(View view) {
        this.aHl = view;
    }

    public boolean EO() {
        return this.aHm;
    }

    public void c(View view, boolean z) {
        if (view != null && this.aHl != null && this.aHl.getParent() == null) {
            this.aHm = true;
            d.R(view).a(view, this.aHl, z);
            EP();
        }
    }

    public void P(View view) {
        if (view != null && this.aHl != null && this.aHl.getParent() != null && (view instanceof ViewGroup)) {
            try {
                EQ();
                ((ViewGroup) view).removeView(this.aHl);
                this.aHm = false;
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
