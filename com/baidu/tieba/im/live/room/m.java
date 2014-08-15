package com.baidu.tieba.im.live.room;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ LiveRoomChatActivity a;
    private final /* synthetic */ GroupData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LiveRoomChatActivity liveRoomChatActivity, GroupData groupData) {
        this.a = liveRoomChatActivity;
        this.b = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.y.a().c(TbadkApplication.getCurrentAccount(), String.valueOf(this.b.getGroupId())));
    }
}
