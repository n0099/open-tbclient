package com.baidu.tieba.im.message.chat;

import protobuf.CommitGroupMsg.CommitGroupMsgReqIdl;
import protobuf.CommitGroupMsg.DataReq;
/* loaded from: classes4.dex */
public class NotifyChatMessage extends CommonGroupChatMessage {
    public NotifyChatMessage() {
        super(202001);
    }

    @Override // com.baidu.tieba.im.message.chat.CommonGroupChatMessage, com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            long longValue = Long.valueOf(getGroupId()).longValue();
            DataReq.Builder builder = new DataReq.Builder();
            builder.content = getContent();
            builder.groupId = Long.valueOf(longValue);
            builder.msgType = Integer.valueOf(getMsgType());
            builder.recordId = Long.valueOf(getRecordId());
            CommitGroupMsgReqIdl.Builder builder2 = new CommitGroupMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public NotifyChatMessage(int i2) {
        super(i2);
    }
}
