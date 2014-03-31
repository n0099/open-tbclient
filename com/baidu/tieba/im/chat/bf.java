package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
final class bf extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ GroupChatActivity b;
    private final /* synthetic */ GroupData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.b = groupChatActivity;
        this.c = groupData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.aa.a().d(TbadkApplication.E(), String.valueOf(this.c.getGroupId())));
    }
}
