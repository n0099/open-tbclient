package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgResIdl;
/* loaded from: classes4.dex */
public class ResponsedPersonalMsgReadMessage extends TbSocketReponsedMessage {
    public long groupId;
    public long hasSentMsgId;
    public long toUid;
    public int toUserType;

    public ResponsedPersonalMsgReadMessage() {
        super(205006);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getHasSentMsgId() {
        return this.hasSentMsgId;
    }

    public long getToUid() {
        return this.toUid;
    }

    public int getToUserType() {
        return this.toUserType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        CommitReceivedPmsgResIdl commitReceivedPmsgResIdl = (CommitReceivedPmsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitReceivedPmsgResIdl.class);
        setError(commitReceivedPmsgResIdl.error.errorno.intValue());
        setErrorString(commitReceivedPmsgResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.hasSentMsgId = commitReceivedPmsgResIdl.data.readMsgId.longValue();
        this.groupId = commitReceivedPmsgResIdl.data.groupId.longValue();
        this.toUid = commitReceivedPmsgResIdl.data.toUid.longValue();
        this.toUserType = commitReceivedPmsgResIdl.data.toUserType.intValue();
    }
}
