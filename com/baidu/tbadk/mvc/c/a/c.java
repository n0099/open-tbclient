package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ b Xy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.Xy = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void a(View view, boolean z) {
        com.baidu.tbadk.mvc.c.b t = com.baidu.tbadk.mvc.g.a.t(view);
        if (t != null) {
            t.az(z);
            t.setView(view);
            this.Xy.dispatchMvcEvent(t);
        }
    }
}
