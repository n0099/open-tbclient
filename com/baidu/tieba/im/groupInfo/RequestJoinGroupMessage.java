package com.baidu.tieba.im.groupInfo;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReqIdl;
import protobuf.ApplyJoinGroup.DataReq;
/* loaded from: classes22.dex */
public class RequestJoinGroupMessage extends TbSocketMessage {
    private long groupId;
    private long inviteUserId;
    private int joinType;
    private String userMsg;

    public RequestJoinGroupMessage() {
        super(CmdConfigSocket.CMD_JOIN_GROUP);
    }

    public int getJoinType() {
        return this.joinType;
    }

    public void setJoinType(int i) {
        this.joinType = i;
    }

    public long getInviteUserId() {
        return this.inviteUserId;
    }

    public void setInviteUserId(long j) {
        this.inviteUserId = j;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public String getUserMsg() {
        return this.userMsg;
    }

    public void setUserMsg(String str) {
        this.userMsg = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(getGroupId());
        builder.inviteUserId = Long.valueOf(getInviteUserId());
        builder.userMsg = getUserMsg();
        builder.joinType = Integer.valueOf(getJoinType());
        ApplyJoinGroupReqIdl.Builder builder2 = new ApplyJoinGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
