package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class PushNotifyMessage extends SocketResponsedMessage {
    private static final long serialVersionUID = 7053886389487061173L;
    private String content;
    private String emitTime;
    private long groupId;
    private int groupType;
    private long newestMsgId;
    private long pushTime;
    private int type;

    public String getEmitTime() {
        return this.emitTime;
    }

    public void setEmitTime(String str) {
        this.emitTime = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

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

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public PushNotifyMessage() {
        super(202006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
    }
}
