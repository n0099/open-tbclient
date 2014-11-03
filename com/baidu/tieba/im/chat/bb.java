package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bb extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ GroupChatActivity aOr;
    private final /* synthetic */ GroupData aOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aOr = groupChatActivity;
        this.aOs = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.aa.Pe().av(TbadkApplication.getCurrentAccount(), String.valueOf(this.aOs.getGroupId())));
    }
}
