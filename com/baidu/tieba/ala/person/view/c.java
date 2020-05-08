package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes3.dex */
public abstract class c {
    protected a.InterfaceC0530a fVH;
    protected a.c fVI;
    protected a.b fVJ;
    protected int fbO;
    protected View mRootView;

    protected abstract void B(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.fbO = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            B(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0530a interfaceC0530a) {
        this.fVH = interfaceC0530a;
    }

    public void a(a.c cVar) {
        this.fVI = cVar;
    }

    public void a(a.b bVar) {
        this.fVJ = bVar;
    }
}
