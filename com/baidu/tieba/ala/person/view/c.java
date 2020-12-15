package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int gFh;
    protected a.InterfaceC0706a hJs;
    protected a.c hJt;
    protected a.b hJu;
    protected View mRootView;

    protected abstract void H(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.gFh = i;
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            H(obj);
            onChangeSkinType(i);
        }
    }

    public void onChangeSkinType(int i) {
    }

    public void a(a.InterfaceC0706a interfaceC0706a) {
        this.hJs = interfaceC0706a;
    }

    public void a(a.c cVar) {
        this.hJt = cVar;
    }

    public void a(a.b bVar) {
        this.hJu = bVar;
    }
}
