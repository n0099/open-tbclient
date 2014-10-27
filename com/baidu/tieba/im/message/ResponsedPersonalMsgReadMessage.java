package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgResIdl;
/* loaded from: classes.dex */
public class ResponsedPersonalMsgReadMessage extends TbSocketReponsedMessage {
    private long groupId;
    private long hasSentMsgId;
    private long toUid;
    private int toUserType;

    public ResponsedPersonalMsgReadMessage() {
        super(205006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        CommitReceivedPmsgResIdl commitReceivedPmsgResIdl = (CommitReceivedPmsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitReceivedPmsgResIdl.class);
        setError(commitReceivedPmsgResIdl.error.errorno.intValue());
        setErrorString(commitReceivedPmsgResIdl.error.usermsg);
        if (getError() == 0) {
            this.hasSentMsgId = commitReceivedPmsgResIdl.data.readMsgId.longValue();
            this.groupId = commitReceivedPmsgResIdl.data.groupId.intValue();
            this.toUid = commitReceivedPmsgResIdl.data.toUid.longValue();
            this.toUserType = commitReceivedPmsgResIdl.data.toUserType.intValue();
        }
    }

    public long getHasSentMsgId() {
        return this.hasSentMsgId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getToUid() {
        return this.toUid;
    }

    public int getToUserType() {
        return this.toUserType;
    }
}
