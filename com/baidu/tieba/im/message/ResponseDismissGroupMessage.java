package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.DelGroup.DelGroupResIdl;
/* loaded from: classes3.dex */
public class ResponseDismissGroupMessage extends SocketResponsedMessage {
    private long groupId;

    public long getGroupId() {
        return this.groupId;
    }

    public ResponseDismissGroupMessage() {
        super(103104);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DelGroupResIdl delGroupResIdl = (DelGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupResIdl.class);
        setError(delGroupResIdl.error.errorno.intValue());
        setErrorString(delGroupResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupId = delGroupResIdl.data.groupId.longValue();
        }
    }
}
