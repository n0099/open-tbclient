package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes11.dex */
public abstract class d {
    protected int gOS;
    protected a.InterfaceC0681a hVs;
    protected a.c hVt;
    protected a.b hVu;
    protected View mRootView;

    protected abstract void C(Object obj);

    public d(View view, int i) {
        this.mRootView = view;
        this.gOS = i;
    }

    public void c(Object obj, int i) {
        if (obj != null) {
            C(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0681a interfaceC0681a) {
        this.hVs = interfaceC0681a;
    }

    public void a(a.c cVar) {
        this.hVt = cVar;
    }

    public void a(a.b bVar) {
        this.hVu = bVar;
    }
}
