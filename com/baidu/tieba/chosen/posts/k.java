package com.baidu.tieba.chosen.posts;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ e aDg;

    private k(e eVar) {
        this.aDg = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(e eVar, k kVar) {
        this(eVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.c.f fVar;
        this.aDg.hideNetRefreshView(this.aDg.getView());
        fVar = this.aDg.MO;
        fVar.b(this.aDg.getView(), true);
        this.aDg.GQ();
    }
}
