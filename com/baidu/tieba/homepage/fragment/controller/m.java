package com.baidu.tieba.homepage.fragment.controller;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bye = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.fragment.a.a aVar;
        com.baidu.tieba.homepage.fragment.a.a aVar2;
        com.baidu.tieba.homepage.fragment.model.b bVar;
        if (com.baidu.adp.lib.util.i.iP()) {
            aVar = this.bye.bxV;
            aVar2 = this.bye.bxV;
            aVar.showLoadingView(aVar2.byB, true);
            bVar = this.bye.bxW;
            bVar.Hx();
        }
    }
}
