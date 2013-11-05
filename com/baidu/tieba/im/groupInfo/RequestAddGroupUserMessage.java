package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public class RequestAddGroupUserMessage extends Message {
    private static final long serialVersionUID = -2740866398211879497L;
    private String decision;
    private long groupId;
    private String notice_id;
    private String sysGroupId;
    private String sysMsgId;
    private String userIds;

    public RequestAddGroupUserMessage() {
        setCmd(103111);
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

    public String getSysGroupId() {
        return this.sysGroupId;
    }

    public void setSysGroupId(String str) {
        this.sysGroupId = str;
    }

    public String getSysMsgId() {
        return this.sysMsgId;
    }

    public void setSysMsgId(String str) {
        this.sysMsgId = str;
    }

    public String getDecision() {
        return this.decision;
    }

    public void setDecision(String str) {
        this.decision = str;
    }
}
