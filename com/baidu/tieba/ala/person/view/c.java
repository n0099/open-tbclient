package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes2.dex */
public abstract class c {
    protected a.InterfaceC0461a fkF;
    protected a.c fkG;
    protected a.b fkH;
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

    public void a(a.InterfaceC0461a interfaceC0461a) {
        this.fkF = interfaceC0461a;
    }

    public void a(a.c cVar) {
        this.fkG = cVar;
    }

    public void a(a.b bVar) {
        this.fkH = bVar;
    }
}
