package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public class PushNotifyMessage extends Message {
    private static final long serialVersionUID = 7053886389487061173L;
    private long groupId;
    private long newestMsgId;
    private long pushTime;

    public long getPushTime() {
        return this.pushTime;
    }

    public void setPushTime(long j) {
        this.pushTime = j;
    }

    public long getNewestMsgId() {
        return this.newestMsgId;
    }

    public void setNewestMsgId(long j) {
        this.newestMsgId = j;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
