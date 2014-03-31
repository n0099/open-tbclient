package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.AddGroupUsers.AddGroupUsersReq;
/* loaded from: classes.dex */
public final class ak extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private String b;
    private String c;
    private int d;
    private String e;
    private int f;
    private long g;
    private int h;

    public ak() {
        super(103111);
    }

    public final void b(long j) {
        this.g = j;
    }

    public final void d(int i) {
        this.h = i;
    }

    public final int i() {
        return this.a;
    }

    public final void e(int i) {
        this.a = i;
    }

    public final String j() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String l() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void f(int i) {
        this.d = i;
    }

    public final String m() {
        return this.e;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void h(int i) {
        this.f = 1;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return AddGroupUsersReq.AddGroupUsersReqIdl.newBuilder().a(AddGroupUsersReq.DataReq.newBuilder().c(this.f).a(this.a).a(this.g).d(this.h).b(this.d).a(this.b).build()).build();
    }
}
