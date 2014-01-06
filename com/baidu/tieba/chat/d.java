package com.baidu.tieba.chat;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        BdListView bdListView;
        a aVar;
        a aVar2;
        com.baidu.tieba.model.i iVar;
        BdListView bdListView2;
        bdListView = this.a.i;
        if (bdListView != null) {
            bdListView2 = this.a.i;
            bdListView2.a();
        }
        aVar = this.a.Y;
        if (aVar != null) {
            aVar2 = this.a.Y;
            iVar = this.a.b;
            aVar2.a(iVar.a());
        }
    }
}
