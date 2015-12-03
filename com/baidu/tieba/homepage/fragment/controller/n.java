package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements q.a {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.bye = aVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.homepage.fragment.a.a aVar;
        com.baidu.tieba.homepage.fragment.model.b bVar;
        aVar = this.bye.bxV;
        aVar.TT();
        bVar = this.bye.bxW;
        bVar.Hx();
    }
}
