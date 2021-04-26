package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.LogTogether.LogTogetherResIdl;
/* loaded from: classes3.dex */
public class DistributeSocketResponse extends SocketResponsedMessage {
    public DistributeSocketResponse() {
        super(303101);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        LogTogetherResIdl logTogetherResIdl = (LogTogetherResIdl) new Wire(new Class[0]).parseFrom(bArr, LogTogetherResIdl.class);
        setError(logTogetherResIdl.error.errorno.intValue());
        setErrorString(logTogetherResIdl.error.errmsg);
    }
}
