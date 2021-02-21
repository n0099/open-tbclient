package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes11.dex */
public abstract class d {
    protected int gPg;
    protected a.InterfaceC0682a hVG;
    protected a.c hVH;
    protected a.b hVI;
    protected View mRootView;

    protected abstract void C(Object obj);

    public d(View view, int i) {
        this.mRootView = view;
        this.gPg = i;
    }

    public void c(Object obj, int i) {
        if (obj != null) {
            C(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0682a interfaceC0682a) {
        this.hVG = interfaceC0682a;
    }

    public void a(a.c cVar) {
        this.hVH = cVar;
    }

    public void a(a.b bVar) {
        this.hVI = bVar;
    }
}
