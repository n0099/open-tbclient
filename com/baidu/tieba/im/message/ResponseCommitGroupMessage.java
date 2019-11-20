package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.im.util.d;
import com.squareup.wire.Wire;
import protobuf.CommitGroupMsg.CommitGroupMsgResIdl;
/* loaded from: classes.dex */
public class ResponseCommitGroupMessage extends ResponseCommitMessage {
    public ResponseCommitGroupMessage() {
        super(CmdConfigSocket.CMD_GROUP_CHAT_MSG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CommitGroupMsgResIdl commitGroupMsgResIdl = (CommitGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitGroupMsgResIdl.class);
        setError(commitGroupMsgResIdl.error.errorno.intValue());
        setErrorString(commitGroupMsgResIdl.error.usermsg);
        if (getError() == 0) {
            setMsgId(d.dr(commitGroupMsgResIdl.data.msgId.longValue()));
            setRecordId(commitGroupMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitGroupMsgResIdl.data.groupId));
        }
    }
}
