package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
public class x extends q implements com.baidu.tieba.im.coder.g {
    private int a;
    private long b;
    private long c;
    private int d;

    public void a(int i) {
        this.d = i;
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public long c() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public long d() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public x() {
        e(202101);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return CommitPusherCountReq.CommitPusherCountReqIdl.newBuilder().a(CommitPusherCountReq.DataReq.newBuilder().c(d()).a(b()).b(c()).build()).build();
    }
}
