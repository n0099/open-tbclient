package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes3.dex */
public abstract class c {
    protected a.InterfaceC0509a fVC;
    protected a.c fVD;
    protected a.b fVE;
    protected int fbJ;
    protected View mRootView;

    protected abstract void A(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fbJ = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            A(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0509a interfaceC0509a) {
        this.fVC = interfaceC0509a;
    }

    public void a(a.c cVar) {
        this.fVD = cVar;
    }

    public void a(a.b bVar) {
        this.fVE = bVar;
    }
}
