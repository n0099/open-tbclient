package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.CommitInviteMsg.CommitInviteMsgResIdl;
import protobuf.CommitInviteMsg.DataRes;
/* loaded from: classes4.dex */
public class ResponseCommitInviteMessage extends SocketResponsedMessage {
    public DataRes mResData;

    public ResponseCommitInviteMessage() {
        super(205002);
    }

    public DataRes getResponseData() {
        return this.mResData;
    }

    public ResponseCommitInviteMessage(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        CommitInviteMsgResIdl commitInviteMsgResIdl = (CommitInviteMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitInviteMsgResIdl.class);
        setError(commitInviteMsgResIdl.error.errorno.intValue());
        setErrorString(commitInviteMsgResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.mResData = commitInviteMsgResIdl.data;
    }
}
