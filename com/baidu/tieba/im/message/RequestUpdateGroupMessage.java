package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public abstract class RequestUpdateGroupMessage extends Message {
    private static final long serialVersionUID = 5970126981799423191L;
    private long groupId;
    public int type;

    public RequestUpdateGroupMessage() {
        setCmd(103102);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
