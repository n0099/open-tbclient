package com.baidu.tieba.enterForum.c;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bND;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bND = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        this.bND.hideNoDataView();
        qVar = this.bND.bNt;
        qVar.setVisibility(8);
        this.bND.startPullRefresh();
    }
}
