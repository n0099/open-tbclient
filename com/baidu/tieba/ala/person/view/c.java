package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes3.dex */
public abstract class c {
    protected int fAN;
    protected a.InterfaceC0589a gxB;
    protected a.c gxC;
    protected a.b gxD;
    protected View mRootView;

    protected abstract void D(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fAN = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            D(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0589a interfaceC0589a) {
        this.gxB = interfaceC0589a;
    }

    public void a(a.c cVar) {
        this.gxC = cVar;
    }

    public void a(a.b bVar) {
        this.gxD = bVar;
    }
}
