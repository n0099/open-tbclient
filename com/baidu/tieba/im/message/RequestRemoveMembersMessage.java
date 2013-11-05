package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestRemoveMembersMessage extends Message {
    private static final long serialVersionUID = 2378265021502869750L;
    private long groupId;
    private String userIds;

    public RequestRemoveMembersMessage() {
        setCmd(103112);
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
}
