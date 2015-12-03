package com.baidu.tbadk.f;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View avt;
    private boolean avu;

    public a(View view) {
        this.avt = view;
    }

    public boolean Dh() {
        return this.avu;
    }

    public void b(View view, boolean z) {
        if (view != null && this.avt != null && this.avt.getParent() == null) {
            this.avu = true;
            d.x(view).a(view, this.avt, z);
            Di();
        }
    }

    public void v(View view) {
        if (view != null && this.avt != null && this.avt.getParent() != null && (view instanceof ViewGroup)) {
            Dj();
            ((ViewGroup) view).removeView(this.avt);
            this.avu = false;
        }
    }

    public void w(View view) {
        b(view, false);
    }

    protected void Di() {
    }

    protected void Dj() {
    }
}
