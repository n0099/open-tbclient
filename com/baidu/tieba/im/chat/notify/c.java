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
        q qVar;
        q qVar2;
        com.baidu.tieba.im.model.p pVar;
        BdListView bdListView2;
        bdListView = this.a.j;
        if (bdListView != null) {
            bdListView2 = this.a.j;
            bdListView2.b();
        }
        qVar = this.a.k;
        if (qVar != null) {
            qVar2 = this.a.k;
            pVar = this.a.c;
            qVar2.a(pVar.b());
        }
    }
}
