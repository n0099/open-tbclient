package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View bxA;
    private boolean bxB;

    public a(View view) {
        this.bxA = view;
    }

    public boolean MJ() {
        return this.bxB;
    }

    public void j(View view, boolean z) {
        if (view != null && this.bxA != null && this.bxA.getParent() == null) {
            this.bxB = true;
            d.bl(view).a(view, this.bxA, z);
            MK();
        }
    }

    public void bk(View view) {
        if (view != null && this.bxA != null && this.bxA.getParent() != null && (view instanceof ViewGroup)) {
            try {
                ML();
                ((ViewGroup) view).removeView(this.bxA);
                this.bxB = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        j(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ML() {
    }
}
