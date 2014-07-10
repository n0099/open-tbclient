package com.baidu.tieba.im.message.chat;

import protobuf.CommitGroupMsg.CommitGroupMsgReqIdl;
import protobuf.CommitGroupMsg.DataReq;
/* loaded from: classes.dex */
public class CommonGroupChatMessage extends ChatMessage {
    public CommonGroupChatMessage() {
        super(202001);
    }

    public CommonGroupChatMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            int intValue = Integer.valueOf(getGroupId()).intValue();
            DataReq.Builder builder = new DataReq.Builder();
            builder.content = getContent();
            builder.groupId = Integer.valueOf(intValue);
            builder.msgType = Integer.valueOf(getMsgType());
            builder.recordId = Long.valueOf(getRecordId());
            CommitGroupMsgReqIdl.Builder builder2 = new CommitGroupMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
