package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
public class ai extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private long b;

    public ai() {
        e(103121);
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public long c() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return DelGroupActivityReq.DelGroupActivityReqIdl.newBuilder().a(DelGroupActivityReq.DataReq.newBuilder().b(b()).a((int) c()).build()).build();
    }
}
