package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int gFf;
    protected a.InterfaceC0706a hJq;
    protected a.c hJr;
    protected a.b hJs;
    protected View mRootView;

    protected abstract void H(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.gFf = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            H(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0706a interfaceC0706a) {
        this.hJq = interfaceC0706a;
    }

    public void a(a.c cVar) {
        this.hJr = cVar;
    }

    public void a(a.b bVar) {
        this.hJs = bVar;
    }
}
