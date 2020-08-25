package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes7.dex */
public abstract class c {
    protected int fRo;
    protected a.InterfaceC0648a gPB;
    protected a.c gPC;
    protected a.b gPD;
    protected View mRootView;

    protected abstract void F(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fRo = i;
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
        this.gPB = interfaceC0648a;
    }

    public void a(a.c cVar) {
        this.gPC = cVar;
    }

    public void a(a.b bVar) {
        this.gPD = bVar;
    }
}
