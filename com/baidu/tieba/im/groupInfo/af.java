package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.AddGroupUsers.AddGroupUsersReq;
/* loaded from: classes.dex */
public final class af extends com.baidu.tieba.im.message.s implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private String c;
    private int d;
    private String e;
    private int f;
    private long g;
    private int h;

    public af() {
        e(103111);
    }

    public final void a(long j) {
        this.g = j;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final int b() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    public final String c() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String d() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final String e() {
        return this.e;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void d(int i) {
        this.f = 1;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return AddGroupUsersReq.AddGroupUsersReqIdl.newBuilder().a(AddGroupUsersReq.DataReq.newBuilder().c(this.f).a(this.a).a(this.g).d(this.h).b(this.d).a(this.b).build()).build();
    }
}
