package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHN;
    private boolean aHO;

    public a(View view2) {
        this.aHN = view2;
    }

    public boolean Fm() {
        return this.aHO;
    }

    public void d(View view2, boolean z) {
        if (view2 != null && this.aHN != null && this.aHN.getParent() == null) {
            this.aHO = true;
            d.Q(view2).a(view2, this.aHN, z);
            Fn();
        }
    }

    public void P(View view2) {
        if (view2 != null && this.aHN != null && this.aHN.getParent() != null && (view2 instanceof ViewGroup)) {
            try {
                Fo();
                ((ViewGroup) view2).removeView(this.aHN);
                this.aHO = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view2) {
        d(view2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fo() {
    }
}
