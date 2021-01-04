package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes11.dex */
public abstract class d {
    protected int gQS;
    protected a.InterfaceC0698a hVE;
    protected a.c hVF;
    protected a.b hVG;
    protected View mRootView;

    protected abstract void D(Object obj);

    public d(View view, int i) {
        this.mRootView = view;
        this.gQS = i;
    }

    public void c(Object obj, int i) {
        if (obj != null) {
            D(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0698a interfaceC0698a) {
        this.hVE = interfaceC0698a;
    }

    public void a(a.c cVar) {
        this.hVF = cVar;
    }

    public void a(a.b bVar) {
        this.hVG = bVar;
    }
}
