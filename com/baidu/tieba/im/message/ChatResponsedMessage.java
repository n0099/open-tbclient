package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ChatResponsedMessage extends ResponsedMessage {
    private String groupId;
    private long msgId;
    private long recordId;

    public ChatResponsedMessage() {
        setCmd(202001);
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
