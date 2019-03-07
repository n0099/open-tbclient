package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroupMsgs.DataReq;
import protobuf.DelGroupMsgs.DelGroupMsgsReqIdl;
/* loaded from: classes3.dex */
public class RequestDelSystemMessage extends TbSocketMessage {
    private long groupId;
    private String msgIds;

    public RequestDelSystemMessage() {
        super(202004);
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

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(getGroupId());
        builder.msgIds = getMsgIds();
        DelGroupMsgsReqIdl.Builder builder2 = new DelGroupMsgsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
