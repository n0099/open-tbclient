package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
public final class ai extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private long b;

    public ai() {
        e(103121);
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(long j) {
        this.b = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return DelGroupActivityReq.DelGroupActivityReqIdl.newBuilder().a(DelGroupActivityReq.DataReq.newBuilder().b(this.a).a((int) this.b).build()).build();
    }
}
