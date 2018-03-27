package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View bxq;
    private boolean bxr;

    public a(View view) {
        this.bxq = view;
    }

    public boolean MJ() {
        return this.bxr;
    }

    public void j(View view, boolean z) {
        if (view != null && this.bxq != null && this.bxq.getParent() == null) {
            this.bxr = true;
            d.bl(view).a(view, this.bxq, z);
            MK();
        }
    }

    public void bk(View view) {
        if (view != null && this.bxq != null && this.bxq.getParent() != null && (view instanceof ViewGroup)) {
            try {
                ML();
                ((ViewGroup) view).removeView(this.bxq);
                this.bxr = false;
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
