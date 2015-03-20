package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e amA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.amA = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b r = com.baidu.tbadk.mvc.h.a.r(view);
        if (r != null) {
            r.setView(view);
            if (this.amA.dispatchMvcEvent(r)) {
            }
        }
    }
}
