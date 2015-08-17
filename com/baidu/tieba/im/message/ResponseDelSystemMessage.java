package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.DelGroupMsgs.DelGroupMsgsResIdl;
/* loaded from: classes.dex */
public class ResponseDelSystemMessage extends SocketResponsedMessage {
    private long groupId;

    public ResponseDelSystemMessage() {
        super(202004);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        DelGroupMsgsResIdl delGroupMsgsResIdl = (DelGroupMsgsResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupMsgsResIdl.class);
        setError(delGroupMsgsResIdl.error.errorno.intValue());
        setErrorString(delGroupMsgsResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = delGroupMsgsResIdl.data.groupId.intValue();
        }
    }
}
