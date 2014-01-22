package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.ReportGroup.ReportGroupRes;
/* loaded from: classes.dex */
public class ch extends cr implements com.baidu.tieba.im.coder.f {
    public ch() {
        e(103103);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        ReportGroupRes.ReportGroupResIdl parseFrom = ReportGroupRes.ReportGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (k()) {
        }
    }
}
