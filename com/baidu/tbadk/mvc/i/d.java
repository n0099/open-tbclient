package com.baidu.tbadk.mvc.i;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
/* loaded from: classes.dex */
public abstract class d<D, S extends com.baidu.tbadk.mvc.e.c> implements com.baidu.tbadk.e.a {
    private final View Xm;
    private S Xv;
    private final ViewEventCenter Yl;
    private D data;

    public abstract void r(D d);

    public d(View view, ViewEventCenter viewEventCenter) {
        this.Xm = view;
        this.Yl = viewEventCenter;
    }

    public View getRootView() {
        return this.Xm;
    }

    public void a(D d, S s) {
        this.data = d;
        this.Xv = s;
        r(d);
        c(s);
    }

    public void c(S s) {
    }
}
