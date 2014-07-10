package com.baidu.tieba.im.live.room;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ LiveRoomChatActivity b;
    private final /* synthetic */ GroupData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LiveRoomChatActivity liveRoomChatActivity, GroupData groupData) {
        this.b = liveRoomChatActivity;
        this.c = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.y.a().d(TbadkApplication.getCurrentAccount(), String.valueOf(this.c.getGroupId())));
    }
}
