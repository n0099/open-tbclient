package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes3.dex */
public abstract class c {
    protected int fpq;
    protected a.InterfaceC0580a gkC;
    protected a.c gkD;
    protected a.b gkE;
    protected View mRootView;

    protected abstract void D(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fpq = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            D(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0580a interfaceC0580a) {
        this.gkC = interfaceC0580a;
    }

    public void a(a.c cVar) {
        this.gkD = cVar;
    }

    public void a(a.b bVar) {
        this.gkE = bVar;
    }
}
