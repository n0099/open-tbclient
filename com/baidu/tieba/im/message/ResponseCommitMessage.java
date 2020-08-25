package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BlockPopInfoData;
/* loaded from: classes2.dex */
public abstract class ResponseCommitMessage extends SocketResponsedMessage {
    private String groupId;
    private BlockPopInfoData mBlockPopInfoData;
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

    public void setBlockPopInfoData(BlockPopInfoData blockPopInfoData) {
        this.mBlockPopInfoData = blockPopInfoData;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.mBlockPopInfoData;
    }
}
