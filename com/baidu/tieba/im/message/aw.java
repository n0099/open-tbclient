package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
public final class aw extends com.baidu.tbadk.message.websockt.d {
    private long a;
    private String b;

    public aw() {
        super(103112);
    }

    public final long i() {
        return this.a;
    }

    public final void b(long j) {
        this.a = j;
    }

    public final String j() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return DelGroupUsersReq.DelGroupUsersReqIdl.newBuilder().a(DelGroupUsersReq.DataReq.newBuilder().a((int) this.a).a(this.b).build()).build();
    }
}
