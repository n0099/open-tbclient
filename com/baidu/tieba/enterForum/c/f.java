package com.baidu.tieba.enterForum.c;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bHP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bHP = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        this.bHP.hideNoDataView();
        qVar = this.bHP.bHF;
        qVar.setVisibility(8);
        this.bHP.startPullRefresh();
    }
}
