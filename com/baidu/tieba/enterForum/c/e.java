package com.baidu.tieba.enterForum.c;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bUy = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        this.bUy.hideNoDataView();
        pVar = this.bUy.bUn;
        pVar.setVisibility(8);
        this.bUy.startPullRefresh();
    }
}
