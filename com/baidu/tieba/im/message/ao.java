package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
public class ao extends s implements com.baidu.tieba.im.coder.g {
    private long a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;

    public ao() {
        e(103004);
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

    public int f() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public String g() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupDetailReq.QueryGroupDetailReqIdl.newBuilder().a(QueryGroupDetailReq.DataReq.newBuilder().d(e()).e(f()).b(c()).c(d()).a(g()).a((int) b()).build()).build();
    }
}
