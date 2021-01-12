package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes10.dex */
public abstract class d {
    protected int gMm;
    protected a.InterfaceC0681a hQX;
    protected a.c hQY;
    protected a.b hQZ;
    protected View mRootView;

    protected abstract void C(Object obj);

    public d(View view, int i) {
        this.mRootView = view;
        this.gMm = i;
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
        this.hQX = interfaceC0681a;
    }

    public void a(a.c cVar) {
        this.hQY = cVar;
    }

    public void a(a.b bVar) {
        this.hQZ = bVar;
    }
}
