package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int fFX;
    protected a.InterfaceC0598a gDc;
    protected a.c gDd;
    protected a.b gDe;
    protected View mRootView;

    protected abstract void D(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fFX = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            D(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0598a interfaceC0598a) {
        this.gDc = interfaceC0598a;
    }

    public void a(a.c cVar) {
        this.gDd = cVar;
    }

    public void a(a.b bVar) {
        this.gDe = bVar;
    }
}
