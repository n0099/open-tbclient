package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.DelGroup.DelGroupResIdl;
/* loaded from: classes4.dex */
public class ResponseDismissGroupMessage extends SocketResponsedMessage {
    public long groupId;

    public ResponseDismissGroupMessage() {
        super(103104);
    }

    public long getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DelGroupResIdl delGroupResIdl = (DelGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupResIdl.class);
        setError(delGroupResIdl.error.errorno.intValue());
        setErrorString(delGroupResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.groupId = delGroupResIdl.data.groupId.longValue();
    }
}
