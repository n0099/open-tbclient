package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.ReportGroup.ReportGroupRes;
/* loaded from: classes.dex */
public class ResponseReportGroupMessage extends SocketResponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        ReportGroupRes.ReportGroupResIdl parseFrom = ReportGroupRes.ReportGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() != 0) {
        }
    }

    public ResponseReportGroupMessage() {
        super(103103);
    }
}
