package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.IncrForumAccessCount.IncrForumAccessCountResIdl;
/* loaded from: classes4.dex */
public class ResponseIncrForumAccessCountSocketMessage extends SocketResponsedMessage {
    public IncrForumAccessCountResIdl mResponseData;

    public ResponseIncrForumAccessCountSocketMessage() {
        super(309360);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        IncrForumAccessCountResIdl incrForumAccessCountResIdl = (IncrForumAccessCountResIdl) new Wire(new Class[0]).parseFrom(bArr, IncrForumAccessCountResIdl.class);
        this.mResponseData = incrForumAccessCountResIdl;
        Error error = incrForumAccessCountResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
