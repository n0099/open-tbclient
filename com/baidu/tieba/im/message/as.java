package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupUserList.QueryGroupUserListReq;
/* loaded from: classes.dex */
public class as extends s implements com.baidu.tieba.im.coder.g {
    private long a;
    private int b;
    private int c;
    private int d;

    public as() {
        e(103005);
    }

    public long b() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public int c() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int d() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int e() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupUserListReq.QueryGroupUserListReqIdl.newBuilder().a(QueryGroupUserListReq.DataReq.newBuilder().a((int) b()).b(c()).d(e()).c(d()).build()).build();
    }
}
