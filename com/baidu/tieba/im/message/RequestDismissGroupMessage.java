package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestDismissGroupMessage extends Message {
    private static final long serialVersionUID = -4043716843036782635L;
    private long groupId;

    public RequestDismissGroupMessage() {
        setCmd(103104);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
