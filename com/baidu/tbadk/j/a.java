package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aHO;
    private boolean aHP;

    public a(View view2) {
        this.aHO = view2;
    }

    public boolean Fk() {
        return this.aHP;
    }

    public void d(View view2, boolean z) {
        if (view2 != null && this.aHO != null && this.aHO.getParent() == null) {
            this.aHP = true;
            d.Q(view2).a(view2, this.aHO, z);
            Fl();
        }
    }

    public void P(View view2) {
        if (view2 != null && this.aHO != null && this.aHO.getParent() != null && (view2 instanceof ViewGroup)) {
            try {
                Fm();
                ((ViewGroup) view2).removeView(this.aHO);
                this.aHP = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view2) {
        d(view2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fm() {
    }
}
