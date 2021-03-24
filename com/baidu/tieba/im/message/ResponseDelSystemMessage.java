package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.DelGroupMsgs.DelGroupMsgsResIdl;
/* loaded from: classes4.dex */
public class ResponseDelSystemMessage extends SocketResponsedMessage {
    public long groupId;

    public ResponseDelSystemMessage() {
        super(202004);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DelGroupMsgsResIdl delGroupMsgsResIdl = (DelGroupMsgsResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupMsgsResIdl.class);
        setError(delGroupMsgsResIdl.error.errorno.intValue());
        setErrorString(delGroupMsgsResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.groupId = delGroupMsgsResIdl.data.groupId.longValue();
    }
}
