package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes6.dex */
public abstract class c {
    protected int dFv;
    protected a.InterfaceC0377a etj;
    protected a.c etk;
    protected a.b etl;
    protected View mRootView;

    protected abstract void z(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.dFv = i;
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
        this.etj = interfaceC0377a;
    }

    public void a(a.c cVar) {
        this.etk = cVar;
    }

    public void a(a.b bVar) {
        this.etl = bVar;
    }
}
