package com.baidu.tieba.im.message;

import com.squareup.wire.Wire;
import d.b.i0.d1.w.b;
import protobuf.CommitGroupMsg.CommitGroupMsgResIdl;
/* loaded from: classes3.dex */
public class ResponseCommitGroupMessage extends ResponseCommitMessage {
    public ResponseCommitGroupMessage() {
        super(202001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.message.ResponseCommitMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CommitGroupMsgResIdl commitGroupMsgResIdl = (CommitGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitGroupMsgResIdl.class);
        setError(commitGroupMsgResIdl.error.errorno.intValue());
        setErrorString(commitGroupMsgResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        setMsgId(b.a(commitGroupMsgResIdl.data.msgId.longValue()));
        setRecordId(commitGroupMsgResIdl.data.recordId.longValue());
        setGroupId(String.valueOf(commitGroupMsgResIdl.data.groupId));
    }
}
