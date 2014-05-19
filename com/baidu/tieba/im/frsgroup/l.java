package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.message.RequestUpgradeMemberGroupMessage;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.core.dialog.c {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.model.n nVar;
        RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
        nVar = this.a.a;
        requestUpgradeMemberGroupMessage.setGroupId(nVar.a());
        requestUpgradeMemberGroupMessage.setUpOrDown(true);
        BdLog.d("send upgrade mem group msg:" + requestUpgradeMemberGroupMessage.getCmd() + " gid:" + requestUpgradeMemberGroupMessage.getGroupId());
        this.a.sendMessage(requestUpgradeMemberGroupMessage);
    }
}
