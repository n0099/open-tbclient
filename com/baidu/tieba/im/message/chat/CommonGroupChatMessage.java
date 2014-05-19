package com.baidu.tieba.im.message.chat;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import protobuf.CommitGroupMsg.CommitGroupMsgReqIdl;
import protobuf.CommitGroupMsg.DataReq;
/* loaded from: classes.dex */
public class CommonGroupChatMessage extends ChatMessage {
    public CommonGroupChatMessage() {
        super(MessageTypes.CMD_GROUP_CHAT_MSG);
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
            BdLog.d("data convert error");
            return null;
        }
    }
}
