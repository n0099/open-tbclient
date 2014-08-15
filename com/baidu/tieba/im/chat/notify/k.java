package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void a() {
        BdListView bdListView;
        com.baidu.tieba.im.model.p pVar;
        BdListView bdListView2;
        n nVar;
        com.baidu.tieba.im.model.p pVar2;
        bdListView = this.a.f;
        if (bdListView != null) {
            pVar = this.a.c;
            if (pVar != null) {
                bdListView2 = this.a.f;
                bdListView2.d();
                nVar = this.a.g;
                pVar2 = this.a.c;
                nVar.a(pVar2.a());
            }
        }
    }
}
