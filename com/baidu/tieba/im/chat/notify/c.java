package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        BdListView bdListView;
        s sVar;
        s sVar2;
        com.baidu.tieba.im.model.r rVar;
        BdListView bdListView2;
        bdListView = this.a.k;
        if (bdListView != null && com.baidu.tieba.im.b.e.d()) {
            bdListView2 = this.a.k;
            bdListView2.c();
        }
        sVar = this.a.l;
        if (sVar != null) {
            sVar2 = this.a.l;
            rVar = this.a.d;
            sVar2.a(rVar.b());
        }
    }
}
