package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
public class au extends q implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;

    public au() {
        e(103103);
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int c() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return ReportGroupReq.ReportGroupReqIdl.newBuilder().a(ReportGroupReq.DataReq.newBuilder().a(b()).b(c()).build()).build();
    }
}
