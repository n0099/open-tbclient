package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.DelGroup.DelGroupResIdl;
/* loaded from: classes.dex */
public class ResponseDismissGroupMessage extends SocketResponsedMessage {
    private long groupId;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public ResponseDismissGroupMessage() {
        super(MessageTypes.CMD_DISSMISS_GROUP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        DelGroupResIdl delGroupResIdl = (DelGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupResIdl.class);
        setError(delGroupResIdl.error.errorno.intValue());
        setErrorString(delGroupResIdl.error.usermsg);
        if (getError() == 0) {
            setGroupId(delGroupResIdl.data.groupId.intValue());
        }
    }
}
