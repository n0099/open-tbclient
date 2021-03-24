package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroupUsers.DataReq;
import protobuf.DelGroupUsers.DelGroupUsersReqIdl;
/* loaded from: classes4.dex */
public class RequestRemoveMembersMessage extends TbSocketMessage {
    public long groupId;
    public String userIds;

    public RequestRemoveMembersMessage() {
        super(103112);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(getGroupId());
        builder.userIds = getUserIds();
        DelGroupUsersReqIdl.Builder builder2 = new DelGroupUsersReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getUserIds() {
        return this.userIds;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setUserIds(String str) {
        this.userIds = str;
    }
}
