package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
public final class az extends s implements com.baidu.tieba.im.coder.g {
    private long a;
    private String b;

    public az() {
        e(103112);
    }

    public final long b() {
        return this.a;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final String c() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return DelGroupUsersReq.DelGroupUsersReqIdl.newBuilder().a(DelGroupUsersReq.DataReq.newBuilder().a((int) this.a).a(this.b).build()).build();
    }
}
