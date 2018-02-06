package com.baidu.tieba.im.groupInfo;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReqIdl;
import protobuf.ApplyJoinGroup.DataReq;
/* loaded from: classes3.dex */
public class RequestJoinGroupMessage extends TbSocketMessage {
    private int groupId;
    private long inviteUserId;
    private int joinType;
    private String userMsg;

    public RequestJoinGroupMessage() {
        super(103110);
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

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
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
        builder.groupId = Integer.valueOf(getGroupId());
        builder.inviteUserId = Long.valueOf(getInviteUserId());
        builder.userMsg = getUserMsg();
        builder.joinType = Integer.valueOf(getJoinType());
        ApplyJoinGroupReqIdl.Builder builder2 = new ApplyJoinGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
