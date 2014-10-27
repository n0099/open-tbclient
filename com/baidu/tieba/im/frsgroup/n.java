package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.RequestUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.GroupLevelModel;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ GroupLevelActivity aXn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GroupLevelActivity groupLevelActivity) {
        this.aXn = groupLevelActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        GroupLevelModel groupLevelModel;
        RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
        groupLevelModel = this.aXn.aXi;
        requestUpgradeMemberGroupMessage.setGroupId(groupLevelModel.getGroupId());
        requestUpgradeMemberGroupMessage.setUpOrDown(true);
        this.aXn.sendMessage(requestUpgradeMemberGroupMessage);
        aVar.dismiss();
    }
}
