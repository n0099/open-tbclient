package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.be;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void onClick(com.baidu.tieba.view.dialog.a aVar) {
        com.baidu.tieba.im.model.f fVar;
        be beVar = new be();
        fVar = this.a.a;
        beVar.a(fVar.a());
        beVar.a(true);
        com.baidu.adp.lib.g.e.d("send upgrade mem group msg:" + beVar.w() + " gid:" + beVar.b());
        com.baidu.tieba.im.messageCenter.e.a().a(beVar);
    }
}
