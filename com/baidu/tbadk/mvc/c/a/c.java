package com.baidu.tbadk.mvc.c.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    final /* synthetic */ b aei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aei = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void a(View view, boolean z) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.aO(z);
            s.setView(view);
            this.aei.dispatchMvcEvent(s);
        }
    }
}
