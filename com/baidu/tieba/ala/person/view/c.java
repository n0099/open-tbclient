package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.tieba.ala.person.adapter.a;
/* loaded from: classes4.dex */
public abstract class c {
    protected int gwN;
    protected a.InterfaceC0693a hAe;
    protected a.c hAf;
    protected a.b hAg;
    protected View mRootView;

    protected abstract void H(Object obj);

    public c(View view, int i) {
        this.mRootView = view;
        this.gwN = i;
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
        this.hAe = interfaceC0693a;
    }

    public void a(a.c cVar) {
        this.hAf = cVar;
    }

    public void a(a.b bVar) {
        this.hAg = bVar;
    }
}
