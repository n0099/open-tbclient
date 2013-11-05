package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public class RequestDelSystemMessage extends Message {
    private static final long serialVersionUID = -6148040987864021047L;
    private long groupId;
    private String msgIds;

    public RequestDelSystemMessage() {
        setCmd(202004);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public String getMsgIds() {
        return this.msgIds;
    }

    public void setMsgIds(String str) {
        this.msgIds = str;
    }
}
