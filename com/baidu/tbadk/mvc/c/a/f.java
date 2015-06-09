package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e anL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.anL = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b u = com.baidu.tbadk.mvc.h.a.u(view);
        if (u != null) {
            u.setView(view);
            if (this.anL.dispatchMvcEvent(u)) {
            }
        }
    }
}
