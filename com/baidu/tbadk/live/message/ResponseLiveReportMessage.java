package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.LiveReport.LiveReportResIdl;
/* loaded from: classes.dex */
public class ResponseLiveReportMessage extends SocketResponsedMessage {
    public ResponseLiveReportMessage() {
        super(107111);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        LiveReportResIdl liveReportResIdl = (LiveReportResIdl) new Wire(new Class[0]).parseFrom(bArr, LiveReportResIdl.class);
        setError(liveReportResIdl.error.errorno.intValue());
        setErrorString(liveReportResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
