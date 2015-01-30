package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e aej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aej = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.setView(view);
            if (this.aej.dispatchMvcEvent(s)) {
            }
        }
    }
}
