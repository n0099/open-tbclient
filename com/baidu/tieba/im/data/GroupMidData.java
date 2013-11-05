package com.baidu.tieba.im.data;

import com.baidu.tieba.im.codec.l;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes.dex */
public class GroupMidData implements Serializable {
    private long groupId;
    private long lastMsgId;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public long getLastMsgId() {
        return this.lastMsgId;
    }

    public void setLastMsgId(long j) {
        this.lastMsgId = j;
    }

    public Map toMap() {
        return l.a().a(this);
    }

    public String toString() {
        return "GroupMidData [groupId=" + this.groupId + ", lastMsgId=" + this.lastMsgId + "]";
    }
}
