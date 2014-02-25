package com.baidu.tieba.chat;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.model.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        BdListView bdListView;
        n nVar;
        n nVar2;
        ag agVar;
        BdListView bdListView2;
        bdListView = this.a.j;
        if (bdListView != null) {
            bdListView2 = this.a.j;
            bdListView2.a();
        }
        nVar = this.a.k;
        if (nVar != null) {
            nVar2 = this.a.k;
            agVar = this.a.c;
            nVar2.a(agVar.a());
        }
    }
}
