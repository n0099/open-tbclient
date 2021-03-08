package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddGroupUsers.AddGroupUsersReqIdl;
import protobuf.AddGroupUsers.DataReq;
/* loaded from: classes7.dex */
public class RequestAddGroupUserMessage extends TbSocketMessage {
    private int decision;
    private long groupId;
    private long inviterUserId;
    private int joinType;
    private String notice_id;
    private int sysGroupId;
    private String sysMsgId;
    private String userIds;

    public RequestAddGroupUserMessage() {
        super(CmdConfigSocket.CMD_ADD_GROUP_USER);
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
}
