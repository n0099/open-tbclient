package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.LogTogether.LogTogetherResIdl;
/* loaded from: classes2.dex */
public class DistributeSocketResponse extends SocketResponsedMessage {
    public DistributeSocketResponse() {
        super(CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LogTogetherResIdl logTogetherResIdl = (LogTogetherResIdl) new Wire(new Class[0]).parseFrom(bArr, LogTogetherResIdl.class);
        setError(logTogetherResIdl.error.errorno.intValue());
        setErrorString(logTogetherResIdl.error.errmsg);
    }
}
