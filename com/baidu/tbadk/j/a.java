package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View bvh;
    private boolean bvi;

    public a(View view) {
        this.bvh = view;
    }

    public boolean Mb() {
        return this.bvi;
    }

    public void j(View view, boolean z) {
        if (view != null && this.bvh != null && this.bvh.getParent() == null) {
            this.bvi = true;
            d.bl(view).a(view, this.bvh, z);
            Mc();
        }
    }

    public void bk(View view) {
        if (view != null && this.bvh != null && this.bvh.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Md();
                ((ViewGroup) view).removeView(this.bvh);
                this.bvi = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        j(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Md() {
    }
}
