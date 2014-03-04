package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.bk;
/* loaded from: classes.dex */
final class j implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public final void onClick(com.baidu.tieba.view.dialog.a aVar) {
        com.baidu.tieba.im.model.f fVar;
        bk bkVar = new bk();
        fVar = this.a.a;
        bkVar.a(fVar.a());
        bkVar.a(true);
        com.baidu.adp.lib.util.e.e("send upgrade mem group msg:" + bkVar.v() + " gid:" + bkVar.b());
        com.baidu.tieba.im.messageCenter.d.a().a(bkVar);
    }
}
