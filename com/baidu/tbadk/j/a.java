package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View bxn;
    private boolean bxo;

    public a(View view) {
        this.bxn = view;
    }

    public boolean MI() {
        return this.bxo;
    }

    public void j(View view, boolean z) {
        if (view != null && this.bxn != null && this.bxn.getParent() == null) {
            this.bxo = true;
            d.bl(view).a(view, this.bxn, z);
            MJ();
        }
    }

    public void bk(View view) {
        if (view != null && this.bxn != null && this.bxn.getParent() != null && (view instanceof ViewGroup)) {
            try {
                MK();
                ((ViewGroup) view).removeView(this.bxn);
                this.bxo = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        j(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MJ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MK() {
    }
}
