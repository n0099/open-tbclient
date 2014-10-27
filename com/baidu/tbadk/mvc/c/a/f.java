package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e Xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Xz = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b t = com.baidu.tbadk.mvc.g.a.t(view);
        if (t != null) {
            t.setView(view);
            if (this.Xz.dispatchMvcEvent(t)) {
            }
        }
    }
}
