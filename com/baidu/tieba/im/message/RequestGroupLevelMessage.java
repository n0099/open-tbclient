package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestGroupLevelMessage extends Message {
    private static final long serialVersionUID = -8634299886533232927L;
    private long groupId;

    public RequestGroupLevelMessage() {
        setCmd(103006);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
