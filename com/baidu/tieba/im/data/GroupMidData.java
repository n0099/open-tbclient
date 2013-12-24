package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupMidData implements Serializable {
    private static final long serialVersionUID = 6961300937590601929L;
    private int groupId;
    private long lastMsgId;

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public long getLastMsgId() {
        return this.lastMsgId;
    }

    public void setLastMsgId(long j) {
        this.lastMsgId = j;
    }

    public String toString() {
        return "GroupMidData [groupId=" + this.groupId + ", lastMsgId=" + this.lastMsgId + "]";
    }
}
