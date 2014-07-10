package com.baidu.tieba.im.groupInfo;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroupMsgs.DataReq;
import protobuf.DelGroupMsgs.DelGroupMsgsReqIdl;
/* loaded from: classes.dex */
public class RequestDelSystemMessage extends TbSocketMessage {
    private int groupId;
    private String msgIds;

    public RequestDelSystemMessage() {
        super(202004);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
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
        builder.groupId = Integer.valueOf(getGroupId());
        builder.msgIds = getMsgIds();
        DelGroupMsgsReqIdl.Builder builder2 = new DelGroupMsgsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
