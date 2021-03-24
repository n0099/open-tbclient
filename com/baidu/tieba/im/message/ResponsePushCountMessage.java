package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.CommitPusherCount.CommitPusherCountResIdl;
/* loaded from: classes4.dex */
public class ResponsePushCountMessage extends SocketResponsedMessage {
    public String groupId;

    public ResponsePushCountMessage() {
        super(202101);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CommitPusherCountResIdl commitPusherCountResIdl = (CommitPusherCountResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPusherCountResIdl.class);
        setError(commitPusherCountResIdl.error.errorno.intValue());
        setErrorString(commitPusherCountResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
