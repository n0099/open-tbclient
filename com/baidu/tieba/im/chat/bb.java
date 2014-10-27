package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bb extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ GroupChatActivity aOd;
    private final /* synthetic */ GroupData aOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aOd = groupChatActivity;
        this.aOe = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.z.Pb().av(TbadkApplication.getCurrentAccount(), String.valueOf(this.aOe.getGroupId())));
    }
}
