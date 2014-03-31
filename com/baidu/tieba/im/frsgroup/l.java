package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.bj;
/* loaded from: classes.dex */
final class l implements com.baidu.tbadk.core.dialog.c {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public final void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.model.m mVar;
        bj bjVar = new bj();
        mVar = this.a.a;
        bjVar.b(mVar.a());
        bjVar.a(true);
        com.baidu.adp.lib.util.f.e("send upgrade mem group msg:" + bjVar.e() + " gid:" + bjVar.i());
        this.a.sendMessage(bjVar);
    }
}
