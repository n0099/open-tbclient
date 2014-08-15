package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.LogTogether.LogTogetherResIdl;
/* loaded from: classes.dex */
public class ResponseDistributeMessage extends SocketResponsedMessage {
    public ResponseDistributeMessage() {
        super(303101);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        LogTogetherResIdl logTogetherResIdl = (LogTogetherResIdl) new Wire(new Class[0]).parseFrom(bArr, LogTogetherResIdl.class);
        setError(logTogetherResIdl.error.errorno.intValue());
        setErrorString(logTogetherResIdl.error.errmsg);
    }
}
