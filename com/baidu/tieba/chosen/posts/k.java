package com.baidu.tieba.chosen.posts;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ e aDf;

    private k(e eVar) {
        this.aDf = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(e eVar, k kVar) {
        this(eVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.c.f fVar;
        this.aDf.hideNetRefreshView(this.aDf.getView());
        fVar = this.aDf.MO;
        fVar.b(this.aDf.getView(), true);
        this.aDf.GP();
    }
}
