package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnLongClickListener {
    final /* synthetic */ e aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aeg = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.setView(view);
            if (this.aeg.dispatchMvcEvent(s)) {
                return true;
            }
        }
        return false;
    }
}
