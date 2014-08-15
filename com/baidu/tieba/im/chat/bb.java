package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bb extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ GroupChatActivity a;
    private final /* synthetic */ GroupData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.a = groupChatActivity;
        this.b = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.y.a().c(TbadkApplication.getCurrentAccount(), String.valueOf(this.b.getGroupId())));
    }
}
