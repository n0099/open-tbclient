package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes7.dex */
public abstract class c {
    protected int fRs;
    protected a.InterfaceC0648a gPF;
    protected a.c gPG;
    protected a.b gPH;
    protected View mRootView;

    protected abstract void F(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fRs = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            F(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0648a interfaceC0648a) {
        this.gPF = interfaceC0648a;
    }

    public void a(a.c cVar) {
        this.gPG = cVar;
    }

    public void a(a.b bVar) {
        this.gPH = bVar;
    }
}
