package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public abstract class ResponseCommitMessage extends SocketResponsedMessage {
    private String groupId;
    private long msgId;
    private long recordId;

    public ResponseCommitMessage(int i) {
        super(i);
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
