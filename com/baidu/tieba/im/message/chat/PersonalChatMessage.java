package com.baidu.tieba.im.message.chat;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReqIdl;
import protobuf.CommitPersonalMsg.DataReq;
/* loaded from: classes2.dex */
public class PersonalChatMessage extends ChatMessage {
    public PersonalChatMessage() {
        super(CmdConfigSocket.CMD_COMMIT_PERSONAL_MSG);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.content = getContent();
            builder.toUid = Long.valueOf(getToUserId());
            builder.msgType = Integer.valueOf(getMsgType());
            builder.recordId = Long.valueOf(getRecordId());
            builder.toUserType = 0;
            builder.st_type = getSt_type();
            CommitPersonalMsgReqIdl.Builder builder2 = new CommitPersonalMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
