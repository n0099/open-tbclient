package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes6.dex */
public abstract class c {
    protected int dGm;
    protected a.InterfaceC0377a eua;
    protected a.c eub;
    protected a.b euc;
    protected View mRootView;

    protected abstract void z(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.dGm = i;
    }

    public void a(Object obj, int i) {
        if (obj != null) {
            z(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0377a interfaceC0377a) {
        this.eua = interfaceC0377a;
    }

    public void a(a.c cVar) {
        this.eub = cVar;
    }

    public void a(a.b bVar) {
        this.euc = bVar;
    }
}
