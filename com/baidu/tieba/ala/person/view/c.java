package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int gqZ;
    protected a.InterfaceC0679a huh;
    protected a.c hui;
    protected a.b huj;
    protected View mRootView;

    protected abstract void H(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.gqZ = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            H(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0679a interfaceC0679a) {
        this.huh = interfaceC0679a;
    }

    public void a(a.c cVar) {
        this.hui = cVar;
    }

    public void a(a.b bVar) {
        this.huj = bVar;
    }
}
