package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnLongClickListener {
    final /* synthetic */ e XD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.XD = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.mvc.c.b t = com.baidu.tbadk.mvc.g.a.t(view);
        if (t != null) {
            t.setView(view);
            if (this.XD.dispatchMvcEvent(t)) {
                return true;
            }
        }
        return false;
    }
}
