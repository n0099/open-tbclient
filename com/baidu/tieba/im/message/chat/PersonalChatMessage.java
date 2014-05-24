package com.baidu.tieba.im.message.chat;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.w;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReqIdl;
import protobuf.CommitPersonalMsg.DataReq;
/* loaded from: classes.dex */
public class PersonalChatMessage extends ChatMessage {
    public PersonalChatMessage() {
        super(MessageTypes.CMD_COMMIT_PERSONAL_MSG);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.content = getContent();
            builder.toUid = Long.valueOf(getToUserId());
            builder.groupId = Integer.valueOf(w.a);
            builder.msgType = Integer.valueOf(getMsgType());
            builder.recordId = Long.valueOf(getRecordId());
            builder.toUserType = 0;
            CommitPersonalMsgReqIdl.Builder builder2 = new CommitPersonalMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            BdLog.d("data convert error");
            return null;
        }
    }
}
