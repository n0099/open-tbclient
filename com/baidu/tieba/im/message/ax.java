package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
public final class ax extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private int b;

    public ax() {
        super(103103);
    }

    public final void d(int i) {
        this.a = i;
    }

    public final void e(int i) {
        this.b = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return ReportGroupReq.ReportGroupReqIdl.newBuilder().a(ReportGroupReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
