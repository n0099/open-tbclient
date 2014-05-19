package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.bw;
import com.squareup.wire.Wire;
import protobuf.CommitGroupMsg.CommitGroupMsgResIdl;
/* loaded from: classes.dex */
public class ResponseCommitGroupMessage extends ResponseCommitMessage {
    public ResponseCommitGroupMessage() {
        super(MessageTypes.CMD_GROUP_CHAT_MSG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        CommitGroupMsgResIdl commitGroupMsgResIdl = (CommitGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitGroupMsgResIdl.class);
        setError(commitGroupMsgResIdl.error.errorno.intValue());
        setErrorString(commitGroupMsgResIdl.error.usermsg);
        if (getError() == 0) {
            setMsgId(bw.b(commitGroupMsgResIdl.data.msgId.longValue()));
            setRecordId(commitGroupMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitGroupMsgResIdl.data.groupId));
        }
    }
}
