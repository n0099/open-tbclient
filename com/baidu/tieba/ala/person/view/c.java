package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int gwu;
    protected a.InterfaceC0693a hzL;
    protected a.c hzM;
    protected a.b hzN;
    protected View mRootView;

    protected abstract void H(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.gwu = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            H(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0693a interfaceC0693a) {
        this.hzL = interfaceC0693a;
    }

    public void a(a.c cVar) {
        this.hzM = cVar;
    }

    public void a(a.b bVar) {
        this.hzN = bVar;
    }
}
