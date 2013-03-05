package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa a;
    private final /* synthetic */ com.baidu.tieba.a.ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, com.baidu.tieba.a.ad adVar) {
        this.a = aaVar;
        this.b = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.ai.c(this.a.a, this.b.c());
    }
}
