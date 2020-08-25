package com.baidu.tieba.im.message.chat;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import protobuf.CommitGroupMsg.CommitGroupMsgReqIdl;
import protobuf.CommitGroupMsg.DataReq;
/* loaded from: classes2.dex */
public class CommonGroupChatMessage extends ChatMessage {
    public CommonGroupChatMessage() {
        super(CmdConfigSocket.CMD_GROUP_CHAT_MSG);
    }

    public CommonGroupChatMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
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
        } catch (Exception e) {
            return null;
        }
    }
}
