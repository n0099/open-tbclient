package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.CommitInviteMsg.CommitInviteMsgResIdl;
import protobuf.CommitInviteMsg.DataRes;
/* loaded from: classes.dex */
public class ResponseCommitInviteMessage extends SocketResponsedMessage {
    private DataRes mResData;

    public ResponseCommitInviteMessage() {
        super(MessageTypes.CMD_COMMIT_INVITE);
    }

    public ResponseCommitInviteMessage(int i) {
        super(i);
    }

    public DataRes getResponseData() {
        return this.mResData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        CommitInviteMsgResIdl commitInviteMsgResIdl = (CommitInviteMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitInviteMsgResIdl.class);
        setError(commitInviteMsgResIdl.error.errorno.intValue());
        setErrorString(commitInviteMsgResIdl.error.usermsg);
        if (getError() == 0) {
            this.mResData = commitInviteMsgResIdl.data;
        }
    }
}
