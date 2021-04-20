package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddGroupUsers.AddGroupUsersReqIdl;
import protobuf.AddGroupUsers.DataReq;
/* loaded from: classes4.dex */
public class RequestAddGroupUserMessage extends TbSocketMessage {
    public int decision;
    public long groupId;
    public long inviterUserId;
    public int joinType;
    public String notice_id;
    public int sysGroupId;
    public String sysMsgId;
    public String userIds;

    public RequestAddGroupUserMessage() {
        super(103111);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.decision = Integer.valueOf(getDecision());
        builder.groupId = Long.valueOf(getGroupId());
        builder.inviteUserId = Long.valueOf(getInviterUserId());
        builder.joinType = Integer.valueOf(getJoinType());
        builder.sysGroupId = Integer.valueOf(getSysGroupId());
        builder.userIds = getUserIds();
        builder.groupId = Long.valueOf(getGroupId());
        AddGroupUsersReqIdl.Builder builder2 = new AddGroupUsersReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getDecision() {
        return this.decision;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getInviterUserId() {
        return this.inviterUserId;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    public int getSysGroupId() {
        return this.sysGroupId;
    }

    public String getSysMsgId() {
        return this.sysMsgId;
    }

    public String getUserIds() {
        return this.userIds;
    }

    public void setDecision(int i) {
        this.decision = i;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setInviterUserId(long j) {
        this.inviterUserId = j;
    }

    public void setJoinType(int i) {
        this.joinType = i;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public void setSysGroupId(int i) {
        this.sysGroupId = i;
    }

    public void setSysMsgId(String str) {
        this.sysMsgId = str;
    }

    public void setUserIds(String str) {
        this.userIds = str;
    }
}
