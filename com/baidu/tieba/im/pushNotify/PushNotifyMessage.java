package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes4.dex */
public class PushNotifyMessage extends SocketResponsedMessage {
    public static final long serialVersionUID = 7053886389487061173L;
    public String content;
    public String emitTime;
    public long groupId;
    public int groupType;
    public long newestMsgId;
    public long pushTime;
    public int type;

    public PushNotifyMessage() {
        super(202006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
    }

    public String getContent() {
        return this.content;
    }

    public String getEmitTime() {
        return this.emitTime;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public long getNewestMsgId() {
        return this.newestMsgId;
    }

    public long getPushTime() {
        return this.pushTime;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEmitTime(String str) {
        this.emitTime = str;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupType(int i2) {
        this.groupType = i2;
    }

    public void setNewestMsgId(long j) {
        this.newestMsgId = j;
    }

    public void setPushTime(long j) {
        this.pushTime = j;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
