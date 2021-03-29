package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BlockPopInfoData;
/* loaded from: classes3.dex */
public abstract class ResponseCommitMessage extends SocketResponsedMessage {
    public String groupId;
    public BlockPopInfoData mBlockPopInfoData;
    public long msgId;
    public long recordId;

    public ResponseCommitMessage(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i, T t) throws Exception;

    public BlockPopInfoData getBlockPopInfoData() {
        return this.mBlockPopInfoData;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public void setBlockPopInfoData(BlockPopInfoData blockPopInfoData) {
        this.mBlockPopInfoData = blockPopInfoData;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }
}
