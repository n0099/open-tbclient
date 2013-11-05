package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public abstract class RequestUpdateGroupMessage extends Message {
    private static final long serialVersionUID = 5970126981799423191L;
    private long groupId;

    public RequestUpdateGroupMessage() {
        setCmd(103102);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
