package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        BdListView bdListView;
        u uVar;
        u uVar2;
        com.baidu.tieba.im.model.p pVar;
        BdListView bdListView2;
        bdListView = this.a.g;
        if (bdListView != null && com.baidu.tieba.im.b.e.d()) {
            bdListView2 = this.a.g;
            bdListView2.d();
        }
        uVar = this.a.h;
        if (uVar != null) {
            uVar2 = this.a.h;
            pVar = this.a.d;
            uVar2.a(pVar.c());
        }
    }
}
