package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes3.dex */
public abstract class c {
    protected a.InterfaceC0473a frg;
    protected a.c frh;
    protected a.b fri;
    protected int mFromType;
    protected View mRootView;

    protected abstract void A(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
    }

    public void a(Object obj, int i) {
        if (obj != null) {
            A(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0473a interfaceC0473a) {
        this.frg = interfaceC0473a;
    }

    public void a(a.c cVar) {
        this.frh = cVar;
    }

    public void a(a.b bVar) {
        this.fri = bVar;
    }
}
