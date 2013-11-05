package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestSearchGroupsMessage extends Message {
    private long groupId;

    public RequestSearchGroupsMessage() {
        setCmd(103007);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
