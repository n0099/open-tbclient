package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class ResponseDelSystemMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5830880858843140267L;
    private long groupId;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
