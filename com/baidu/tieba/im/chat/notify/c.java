package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        BdListView bdListView;
        p pVar;
        p pVar2;
        com.baidu.tieba.im.model.p pVar3;
        BdListView bdListView2;
        bdListView = this.a.i;
        if (bdListView != null) {
            bdListView2 = this.a.i;
            bdListView2.b();
        }
        pVar = this.a.j;
        if (pVar != null) {
            pVar2 = this.a.j;
            pVar3 = this.a.b;
            pVar2.a(pVar3.a());
        }
    }
}
