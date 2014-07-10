package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.RequestUpgradeMemberGroupMessage;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.model.l lVar;
        RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
        lVar = this.a.a;
        requestUpgradeMemberGroupMessage.setGroupId(lVar.a());
        requestUpgradeMemberGroupMessage.setUpOrDown(true);
        this.a.sendMessage(requestUpgradeMemberGroupMessage);
    }
}
