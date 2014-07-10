package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.ReportGroup.ReportGroupResIdl;
/* loaded from: classes.dex */
public class ResponseReportGroupMessage extends SocketResponsedMessage {
    public ResponseReportGroupMessage() {
        super(103103);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        ReportGroupResIdl reportGroupResIdl = (ReportGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, ReportGroupResIdl.class);
        setError(reportGroupResIdl.error.errorno.intValue());
        setErrorString(reportGroupResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
