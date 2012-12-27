package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab a;
    private final /* synthetic */ com.baidu.tieba.a.af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, com.baidu.tieba.a.af afVar) {
        this.a = abVar;
        this.b = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.ag.c(this.a.a, this.b.c());
    }
}
