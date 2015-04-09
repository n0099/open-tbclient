package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ GroupChatActivity aWL;
    private final /* synthetic */ GroupData val$groupData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aWL = groupChatActivity;
        this.val$groupData = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.c.TA().aF(TbadkApplication.getCurrentAccount(), String.valueOf(this.val$groupData.getGroupId())));
    }
}
