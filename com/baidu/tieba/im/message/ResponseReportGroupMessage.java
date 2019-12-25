package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.ReportGroup.ReportGroupResIdl;
/* loaded from: classes7.dex */
public class ResponseReportGroupMessage extends SocketResponsedMessage {
    public ResponseReportGroupMessage() {
        super(CmdConfigSocket.CMD_REPORT_GROUP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ReportGroupResIdl reportGroupResIdl = (ReportGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, ReportGroupResIdl.class);
        setError(reportGroupResIdl.error.errorno.intValue());
        setErrorString(reportGroupResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
