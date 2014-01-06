package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.ReportGroup.ReportGroupRes;
/* loaded from: classes.dex */
public class bv extends cc implements com.baidu.tieba.im.coder.f {
    public bv() {
        e(103103);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        ReportGroupRes.ReportGroupResIdl parseFrom = ReportGroupRes.ReportGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (i()) {
        }
    }
}
