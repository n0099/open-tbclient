package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
public final class ba extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;

    public ba() {
        e(103103);
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return ReportGroupReq.ReportGroupReqIdl.newBuilder().a(ReportGroupReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
