package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int fUD;
    protected a.InterfaceC0645a gTn;
    protected a.c gTo;
    protected a.b gTp;
    protected View mRootView;

    protected abstract void G(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fUD = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            G(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0645a interfaceC0645a) {
        this.gTn = interfaceC0645a;
    }

    public void a(a.c cVar) {
        this.gTo = cVar;
    }

    public void a(a.b bVar) {
        this.gTp = bVar;
    }
}
