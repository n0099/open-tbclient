package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View bvq;
    private boolean bvr;

    public a(View view) {
        this.bvq = view;
    }

    public boolean Md() {
        return this.bvr;
    }

    public void j(View view, boolean z) {
        if (view != null && this.bvq != null && this.bvq.getParent() == null) {
            this.bvr = true;
            d.bl(view).a(view, this.bvq, z);
            Me();
        }
    }

    public void bk(View view) {
        if (view != null && this.bvq != null && this.bvq.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Mf();
                ((ViewGroup) view).removeView(this.bvq);
                this.bvr = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        j(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Me() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mf() {
    }
}
