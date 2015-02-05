package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aeg = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.setView(view);
            if (this.aeg.dispatchMvcEvent(s)) {
            }
        }
    }
}
