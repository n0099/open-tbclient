package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnLongClickListener {
    final /* synthetic */ e amA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.amA = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.mvc.c.b r = com.baidu.tbadk.mvc.h.a.r(view);
        if (r != null) {
            r.setView(view);
            if (this.amA.dispatchMvcEvent(r)) {
                return true;
            }
        }
        return false;
    }
}
