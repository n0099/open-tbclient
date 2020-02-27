package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroupUsers.DataReq;
import protobuf.DelGroupUsers.DelGroupUsersReqIdl;
/* loaded from: classes8.dex */
public class RequestRemoveMembersMessage extends TbSocketMessage {
    private long groupId;
    private String userIds;

    public RequestRemoveMembersMessage() {
        super(CmdConfigSocket.CMD_REMOVE_MEMBERS);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public String getUserIds() {
        return this.userIds;
    }

    public void setUserIds(String str) {
        this.userIds = str;
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
}
