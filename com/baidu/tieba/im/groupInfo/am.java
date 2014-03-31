package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
public final class am extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private String b;
    private long c;
    private int d;

    public am() {
        super(103110);
    }

    public final void d(int i) {
        this.d = i;
    }

    public final void b(long j) {
        this.c = j;
    }

    public final int i() {
        return this.a;
    }

    public final void e(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return ApplyJoinGroupReq.ApplyJoinGroupReqIdl.newBuilder().a(ApplyJoinGroupReq.DataReq.newBuilder().a(this.a).a(this.c).a(this.b).b(this.d).build()).build();
    }
}
