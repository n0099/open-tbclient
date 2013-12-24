package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.im.message.n implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private long c;
    private int d;

    public ag() {
        e(103110);
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public long c() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public int d() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public String e() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return ApplyJoinGroupReq.ApplyJoinGroupReqIdl.newBuilder().a(ApplyJoinGroupReq.DataReq.newBuilder().a(d()).a(c()).a(e()).b(b()).build()).build();
    }
}
