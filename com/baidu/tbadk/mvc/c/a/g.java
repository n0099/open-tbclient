package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnLongClickListener {
    final /* synthetic */ e anL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.anL = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.mvc.c.b u = com.baidu.tbadk.mvc.h.a.u(view);
        if (u != null) {
            u.setView(view);
            if (this.anL.dispatchMvcEvent(u)) {
                return true;
            }
        }
        return false;
    }
}
