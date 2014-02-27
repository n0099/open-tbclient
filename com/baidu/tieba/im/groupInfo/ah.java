package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
public final class ah extends com.baidu.tieba.im.message.s implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private long c;
    private int d;

    public ah() {
        e(103110);
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final int b() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return ApplyJoinGroupReq.ApplyJoinGroupReqIdl.newBuilder().a(ApplyJoinGroupReq.DataReq.newBuilder().a(this.a).a(this.c).a(this.b).b(this.d).build()).build();
    }
}
