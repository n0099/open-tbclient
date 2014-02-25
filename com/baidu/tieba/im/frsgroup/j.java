package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.bk;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void onClick(com.baidu.tieba.view.dialog.a aVar) {
        com.baidu.tieba.im.model.f fVar;
        bk bkVar = new bk();
        fVar = this.a.a;
        bkVar.a(fVar.a());
        bkVar.a(true);
        com.baidu.adp.lib.util.f.e("send upgrade mem group msg:" + bkVar.w() + " gid:" + bkVar.b());
        com.baidu.tieba.im.messageCenter.e.a().a(bkVar);
    }
}
