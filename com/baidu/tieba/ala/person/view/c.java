package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int ggW;
    protected a.InterfaceC0663a hil;
    protected a.c him;
    protected a.b hin;
    protected View mRootView;

    protected abstract void H(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.ggW = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            H(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0663a interfaceC0663a) {
        this.hil = interfaceC0663a;
    }

    public void a(a.c cVar) {
        this.him = cVar;
    }

    public void a(a.b bVar) {
        this.hin = bVar;
    }
}
