package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.RequestUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.GroupLevelModel;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ GroupLevelActivity aXB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GroupLevelActivity groupLevelActivity) {
        this.aXB = groupLevelActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        GroupLevelModel groupLevelModel;
        RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
        groupLevelModel = this.aXB.aXw;
        requestUpgradeMemberGroupMessage.setGroupId(groupLevelModel.getGroupId());
        requestUpgradeMemberGroupMessage.setUpOrDown(true);
        this.aXB.sendMessage(requestUpgradeMemberGroupMessage);
        aVar.dismiss();
    }
}
