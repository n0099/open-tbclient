package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bc extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ GroupChatActivity b;
    private final /* synthetic */ GroupData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.b = groupChatActivity;
        this.c = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.y.a().d(TbadkApplication.getCurrentAccount(), String.valueOf(this.c.getGroupId())));
    }
}
