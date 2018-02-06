package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddGroupUsers.AddGroupUsersReqIdl;
import protobuf.AddGroupUsers.DataReq;
/* loaded from: classes3.dex */
public class RequestAddGroupUserMessage extends TbSocketMessage {
    private int decision;
    private int groupId;
    private long inviterUserId;
    private int joinType;
    private String notice_id;
    private int sysGroupId;
    private String sysMsgId;
    private String userIds;

    public RequestAddGroupUserMessage() {
        super(103111);
    }

    public long getInviterUserId() {
        return this.inviterUserId;
    }

    public void setInviterUserId(long j) {
        this.inviterUserId = j;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public void setJoinType(int i) {
        this.joinType = i;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public String getUserIds() {
        return this.userIds;
    }

    public void setUserIds(String str) {
        this.userIds = str;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public int getSysGroupId() {
        return this.sysGroupId;
    }

    public void setSysGroupId(int i) {
        this.sysGroupId = i;
    }

    public String getSysMsgId() {
        return this.sysMsgId;
    }

    public void setSysMsgId(String str) {
        this.sysMsgId = str;
    }

    public int getDecision() {
        return this.decision;
    }

    public void setDecision(int i) {
        this.decision = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.decision = Integer.valueOf(getDecision());
        builder.groupId = Integer.valueOf(getGroupId());
        builder.inviteUserId = Long.valueOf(getInviterUserId());
        builder.joinType = Integer.valueOf(getJoinType());
        builder.sysGroupId = Integer.valueOf(getSysGroupId());
        builder.userIds = getUserIds();
        builder.groupId = Integer.valueOf(getGroupId());
        AddGroupUsersReqIdl.Builder builder2 = new AddGroupUsersReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
