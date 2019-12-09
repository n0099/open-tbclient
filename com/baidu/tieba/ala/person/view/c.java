package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes6.dex */
public abstract class c {
    protected int dFv;
    protected a.InterfaceC0372a etj;
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

    public void a(a.InterfaceC0372a interfaceC0372a) {
        this.etj = interfaceC0372a;
    }

    public void a(a.c cVar) {
        this.etk = cVar;
    }

    public void a(a.b bVar) {
        this.etl = bVar;
    }
}
