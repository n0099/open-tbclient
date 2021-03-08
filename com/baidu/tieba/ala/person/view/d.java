package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes10.dex */
public abstract class d {
    protected int gQP;
    protected a.InterfaceC0688a hXp;
    protected a.c hXq;
    protected a.b hXr;
    protected View mRootView;

    protected abstract void E(Object obj);

    public d(View view, int i) {
        this.mRootView = view;
        this.gQP = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            E(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0688a interfaceC0688a) {
        this.hXp = interfaceC0688a;
    }

    public void a(a.c cVar) {
        this.hXq = cVar;
    }

    public void a(a.b bVar) {
        this.hXr = bVar;
    }
}
